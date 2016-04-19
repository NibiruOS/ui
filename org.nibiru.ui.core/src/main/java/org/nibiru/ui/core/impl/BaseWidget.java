package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;

public abstract class BaseWidget implements Widget {
	// Widget size after measuring phase
	private int measuredWidth;
	private int measuredHeight;

	private boolean needsMeasureAgain = false;

	private MeasureSpec mOldWidthMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);

	private MeasureSpec mOldHeightMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);

	private Style style = Style.DEFAULT;
	private IsParent parent;

	@Override
	public int getMeasuredHeight() {
		return measuredHeight;
	}

	@Override
	public int getMeasuredWidth() {
		return measuredWidth;
	}

	public final void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
		onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	protected void onMeasure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
		updateSize(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
	}

	/**
	 * This method resolves the final size for panels after measuring the children.
	 * If parent had an exactly size, we use that one, if not we use the one calculated after measuring all its children.
	 * @param size value calculated after measuring all children
	 * @param measureSpec restrictions imposed to the widget
	 * @return widget size
	 */
	public int resolveSize(int size, MeasureSpec measureSpec, boolean width) {
		int result = size;
		switch (measureSpec.getType()) {
		case UNSPECIFIED:
			result = size;
			break;
		case AT_MOST:
			if(width) {
				if (getStyle().getWidth().equals(Size.MATCH_PARENT)) {
					result = measureSpec.getValue();
				} else {
					result = size;
				}
			} else {
				if (getStyle().getHeight().equals(Size.MATCH_PARENT)) {
					result = measureSpec.getValue();
				} else {
					result = size;
				}
			}
			break;
		case EXACTLY:
			result = measureSpec.getValue();
			break;
		}
		return result;
	}

	public static int getDefaultSize(int size, MeasureSpec measureSpec) {
		int result = size;

		switch (measureSpec.getType()) {
		case UNSPECIFIED:
			result = size;
			break;
		case AT_MOST:
		case EXACTLY:
			result = measureSpec.getValue();
			break;
		}
		return result;
	}

	protected void updateSize(int measuredWidth, int measuredHeight) {
		this.measuredWidth = measuredWidth;
		this.measuredHeight = measuredHeight;
	}

	@Override
	public void layout() {
		applyStyle();
		//TODO this is in case the children violates the parent size
	    if (needsMeasureAgain) {
	    	onMeasure(mOldWidthMeasureSpec, mOldHeightMeasureSpec);
	    	needsMeasureAgain = false;
	    }

        onLayout();
	}

	protected void onLayout() {

    }

	@Override
	public void setStyle(Style style) {
        this.style = checkNotNull(style);
	}

    @Override
    public Style getStyle() {
        return style;
    }

    @Override
	public IsParent getParent() {
		return parent;
	}

	@Override
	public void setParent(@Nullable IsParent parent) {
		this.parent = parent;
	}

	protected double colorToDouble(int color) {
		return color / 255d;
	}
}