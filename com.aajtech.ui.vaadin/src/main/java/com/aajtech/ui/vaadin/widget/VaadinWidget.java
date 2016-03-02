package com.aajtech.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.aajtech.ui.core.api.Style;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.Component;

abstract class VaadinWidget<T extends Component> implements Widget, Serializable {
	final T component;

	VaadinWidget(T component) {
		this.component = checkNotNull(component);
	}

	@Override
	public T asNative() {
		return component;
	}

	@Override
	public void setStyle(Style style) {
		// TODO: Add styles only once?
		Styles styles = Page.getCurrent().getStyles();
		styles.add(style.asCss());
		component.setStyleName(style.getId());
	}
}
