package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;

import javax.annotation.Nullable;

public abstract class BaseControlWidget<T> extends BaseWidget {
	protected T control;

	//TODO: control is mutable and nullable just for a problem related to Android styles.
	// You need to set the styles before creationg the control.
	// When removing native styles, it could be final and not nullable again
	protected BaseControlWidget(@Nullable T control) {
		this.control = control;
	}

	@Override
	public T asNative() {
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
            width = widthSize;
        } else {
            width = getNativeWidth();
            
            if (widthMode == Type.AT_MOST) {
            	width = Math.min(widthSize, width);
            }
        }

        if (heightMode == Type.EXACTLY) {
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

	public void scheduleLayout() {
		if (getParent() != null) {
			getParent().scheduleLayout();
		}
	}

	abstract protected int getNativeHeight();

	abstract protected int getNativeWidth();

	abstract protected void setNativeSize(int measuredWidth, int measuredHeight);
}