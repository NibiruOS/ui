package org.nibiru.ui.vaadin.widget;

import org.nibiru.ui.core.api.HorizontalPanel;

import com.vaadin.ui.HorizontalLayout;

public class VaadinHorizontalPanel extends VaadinContainer<HorizontalLayout>implements HorizontalPanel {
	public VaadinHorizontalPanel() {
		this(new HorizontalLayout());
	}

	public VaadinHorizontalPanel(HorizontalLayout horizontalLayout) {
		super(horizontalLayout);
	}
}
