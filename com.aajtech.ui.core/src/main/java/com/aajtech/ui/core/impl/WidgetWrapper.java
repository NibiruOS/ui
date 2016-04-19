package com.aajtech.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.api.Widget;

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
	public void addStyleName(Enum<?> styleClass) {
		// Not supported... styles are platform specific.
	}
}
