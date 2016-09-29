package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.Size;

public class WidgetWrapper implements Widget {
	private final Object nativeWidget;

	public WidgetWrapper(Object nativeWidget) {
		this.nativeWidget = checkNotNull(nativeWidget);
	}

	@Override
	public Object asNative() {
		return nativeWidget;
	}

	@Override
	public void setStyleName(Enum<?> styleClass) {
		// Not supported... styles are platform specific.
	}

	@Override
	public int getMeasuredHeight() {
		// Not supported...
		return 0;
	}


	@Override
	public int getMeasuredWidth() {
		// Not supported...
		return 0;
	}

	@Override
	public void setHeight(Size height) {
		// Not supported...
	}

	@Override
	public void setWidth(Size width) {
		// Not supported...
	}

	@Override
	public void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
		// Not supported...
	}

	@Override
	public void layout() {
		// Not supported...
	}

	@Override
	public Size getHeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size getWidth() {
		// TODO Auto-generated method stub
		return null;
	}

}
