package org.nibiru.ui.vaadin.widget;

import org.nibiru.ui.core.api.VerticalPanel;

import com.vaadin.ui.VerticalLayout;

public class VaadinVerticalPanel extends VaadinContainer<VerticalLayout> implements VerticalPanel {
	public VaadinVerticalPanel() {
		this(new VerticalLayout());
	}

	public VaadinVerticalPanel(VerticalLayout verticalLayout) {
		super(verticalLayout);
	}
}
