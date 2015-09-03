package com.aajtech.ui.vaadin;

import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class VaadinVerticalPanel implements VerticalPanel {
	private final VerticalLayout verticalLayout = new VerticalLayout();

	@Override
	public void add(Widget widget) {
		verticalLayout.addComponent((Component) widget.asNative());
	}

	@Override
	public Object asNative() {
		return verticalLayout;
	}

}
