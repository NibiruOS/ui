package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.VerticalPanel;
import com.vaadin.ui.VerticalLayout;

public class VaadinVerticalPanel extends VaadinContainer<VerticalLayout>implements VerticalPanel {
	public VaadinVerticalPanel() {
		super(new VerticalLayout());
	}
}
