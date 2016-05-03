package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gwt.user.client.ui.Widget;

abstract class GwtWidget<T extends Widget> implements com.aajtech.ui.core.api.Widget {
	final T control;

	GwtWidget(T control) {
		this.control = checkNotNull(control);
	}

	@Override
	public T asNative() {
		return control;
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		control.addStyleName(STYLE_NAME_PREFIX + styleName.name().toLowerCase());
	}
}
