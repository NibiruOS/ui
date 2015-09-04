package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gwt.user.client.ui.Widget;

abstract class GwtWidget<T extends Widget> implements com.aajtech.ui.core.api.Widget {
	final T widget;

	GwtWidget(T widget) {
		this.widget = checkNotNull(widget);
	}

	@Override
	public T asNative() {
		return widget;
	}
}
