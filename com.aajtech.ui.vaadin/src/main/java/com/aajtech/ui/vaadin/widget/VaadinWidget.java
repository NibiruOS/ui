package com.aajtech.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.Component;

abstract class VaadinWidget<T extends Component> implements Widget, Serializable {
	private static final long serialVersionUID = -1979735392364614102L;
	final T component;

	VaadinWidget(T component) {
		this.component = checkNotNull(component);
	}

	@Override
	public T asNative() {
		return component;
	}
}
