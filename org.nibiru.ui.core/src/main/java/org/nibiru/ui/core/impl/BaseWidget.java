package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.Size;

public abstract class BaseWidget implements Widget {
	private Size height = Size.WRAP_CONTENT;
	private Size width = Size.WRAP_CONTENT;
	private int measuredWidth;
	private int measuredHeight;

	@Override
	public void setHeight(Size height) {
		this.height = checkNotNull(height);
	}

	@Override
	public void setWidth(Size width) {
		this.width = checkNotNull(width);
	}

	public Size getHeight() {
		return height;
	}

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

	protected MeasureSpec computeChildMeasureSpec(MeasureSpec parentMeasureSpec, Size size) {
		switch (parentMeasureSpec.getType()) {
		case AT_MOST:
			switch (size.getType()) {
			case EXACTLY:
				return MeasureSpec.atMost(Math.min(parentMeasureSpec.getValue(), size.getValue()));
			case MATCH_PARENT:
				return MeasureSpec.atMost(parentMeasureSpec.getValue());
			case WRAP_CONTENT:
				return MeasureSpec.UNSPECIFIED;
			}
		case UNSPECIFIED:
			switch (size.getType()) {
			case EXACTLY:
				return MeasureSpec.atMost(size.getValue());
			case MATCH_PARENT: // TODO: Should I know parent size here?
			case WRAP_CONTENT:
				return MeasureSpec.UNSPECIFIED;
			}
		}
		throw new IllegalStateException();
	}

	protected void updateSize(int measuredWidth, int measuredHeight) {
		this.measuredWidth = measuredWidth;
		this.measuredHeight = measuredHeight;
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		// TODO Auto-generated method stub
	}
}
