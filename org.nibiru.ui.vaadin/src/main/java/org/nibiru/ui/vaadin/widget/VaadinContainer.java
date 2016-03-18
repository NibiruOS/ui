package org.nibiru.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import com.google.common.collect.Lists;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

abstract class VaadinContainer<T extends AbstractComponentContainer> extends VaadinWidget<T>implements Container {
	private final List<Widget> children;

	VaadinContainer(T component) {
		super(component);
		children = Lists.newArrayList();
	}

	@Override
	public void add(Widget child) {
		checkNotNull(child);
		control.addComponent((Component) child.asNative());
		children.add(child);
		child.setParent(this);
	}

	@Override
	public void clear() {
		control.removeAllComponents();
	}

	public Iterable<Widget> getChildren() {
		return children;
	}

	@Override
	public void layout() {
	}
}
