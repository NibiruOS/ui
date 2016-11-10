package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.Size;

public abstract class BaseWidget implements Widget {
	// Default size for widgets if they don't specify one in particularly using the DSL
	private Size height = Size.WRAP_CONTENT;
	private Size width = Size.WRAP_CONTENT;
	
	// Widget size after measuring phase
	private int measuredWidth;
	private int measuredHeight;
	
	private boolean needsMeasureAgain = false;
	
	private MeasureSpec mOldWidthMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);
	
	private MeasureSpec mOldHeightMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);

	private IsParent parent; 
	
	@Override
	public void setHeight(Size height) {
		this.height = checkNotNull(height);
	}

	@Override
	public void setWidth(Size width) {
		this.width = checkNotNull(width);
	}

	@Override
	public Size getHeight() {
		return height;
	}

	@Override
	public Size getWidth() {
		return width;
	}

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
	public int resolveSize(int size, MeasureSpec measureSpec) {
		int result = size;
		switch (measureSpec.getType()) {
		case UNSPECIFIED:
			result = size;
			break;
		case AT_MOST:
			if (measureSpec.getValue() < size) {
				needsMeasureAgain = true;
			} else {
				result = size;
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
	public IsParent getParent() {
		return parent;
	}

	@Override
	public void setParent(@Nullable IsParent parent) {
		this.parent = parent;
	}
}