package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

abstract class VaadinContainer<T extends AbstractComponentContainer> extends VaadinWidget<T>implements Container {
	VaadinContainer(T component) {
		super(component);
	}

	@Override
	public void add(Widget child) {
		component.addComponent((Component) child.asNative());
	}

	@Override
	public void clear() {
		component.removeAllComponents();
	}
}
