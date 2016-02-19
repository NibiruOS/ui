package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.api.Style;
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

	@Override
	public void setStyle(Style style) {
		// TODO Auto-generated method stub
	}
}
