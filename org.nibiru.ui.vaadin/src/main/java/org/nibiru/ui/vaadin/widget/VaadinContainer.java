package org.nibiru.ui.vaadin.widget;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

abstract class VaadinContainer<T extends AbstractComponentContainer> extends VaadinWidget<T>implements Container {
	VaadinContainer(T component) {
		super(component);
	}

	@Override
	public void add(Widget child) {
		control.addComponent((Component) child.asNative());
	}

	@Override
	public void clear() {
		control.removeAllComponents();
	}
}
