package com.aajtech.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.Component;

abstract class VaadinWidget<T extends Component> implements Widget, Serializable {
	final T control;

	VaadinWidget(T component) {
		this.control = checkNotNull(component);
	}

	@Override
	public T asNative() {
		return control;
	}

	@Override
	public void addStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		control.addStyleName(STYLE_NAME_PREFIX + styleName.name().toLowerCase());
	}
}
