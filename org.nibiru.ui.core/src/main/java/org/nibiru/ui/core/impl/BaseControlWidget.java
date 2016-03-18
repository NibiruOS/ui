package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;

public abstract class BaseControlWidget<T> extends BaseWidget {
	protected final T control;

	protected BaseControlWidget(T control) {
		this.control = checkNotNull(control);
	}

	@Override
	public Object asNative() {
		return control;
	}

	@Override
	public void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {

		MeasureSpec childWidthSpec = computeChildMeasureSpec(widthMeasureSpec, getWidth());
		int measuredWidth;
		if (childWidthSpec.getType() == Type.UNSPECIFIED) {
			measuredWidth = getNativeWidth();
		} else {
			measuredWidth = childWidthSpec.getValue();
		}

		MeasureSpec childHeightSpec = computeChildMeasureSpec(heightMeasureSpec, getHeight());
		int measuredHeight;
		if (childHeightSpec.getType() == Type.UNSPECIFIED) {
			measuredHeight = getNativeHeight();
		} else {
			measuredHeight = childHeightSpec.getValue();
		}

		updateSize(measuredWidth, measuredHeight);
	}

	@Override
	public void layout() {
		setNativeSize(getMeasuredWidth(), getMeasuredHeight());
	}

	abstract protected int getNativeHeight();

	abstract protected int getNativeWidth();

	abstract protected void setNativeSize(int measuredWidth, int measuredHeight);
}
