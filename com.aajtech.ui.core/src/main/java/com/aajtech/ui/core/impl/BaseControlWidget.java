package com.aajtech.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.api.layout.MeasureSpec;
import com.aajtech.ui.core.api.layout.MeasureSpec.Type;

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
    protected void onMeasure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        Type widthMode = widthMeasureSpec.getType();
        Type heightMode = heightMeasureSpec.getType();
        int widthSize = widthMeasureSpec.getValue();
        int heightSize = heightMeasureSpec.getValue();

        int width;
        int height;

        if (widthMode == Type.EXACTLY) {
            // Parent has told us how big to be. So be it.
            width = widthSize;
        } else {
            width = getNativeWidth();
            
            if (widthMode == Type.AT_MOST) {
            	width = Math.min(widthSize, width);
            }
        }

        if (heightMode == Type.EXACTLY) {
            // Parent has told us how big to be. So be it.
            height = heightSize;
        } else {
            height = getNativeHeight();

            if (heightMode == Type.AT_MOST) {
                height = Math.min(heightSize, height);
            }
        }

        updateSize(width, height);
    }

	@Override
    public void onLayout() {
    	setNativeSize(getMeasuredWidth(), getMeasuredHeight());
    }

	abstract protected int getNativeHeight();

	abstract protected int getNativeWidth();

	abstract protected void setNativeSize(int measuredWidth, int measuredHeight);
}