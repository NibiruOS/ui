package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.VerticalPanel;
import com.vaadin.ui.VerticalLayout;

public class VaadinVerticalPanel extends VaadinContainer<VerticalLayout>implements VerticalPanel {
	private static final long serialVersionUID = 8529035747508919797L;

	public VaadinVerticalPanel() {
		super(new VerticalLayout());
	}
}
