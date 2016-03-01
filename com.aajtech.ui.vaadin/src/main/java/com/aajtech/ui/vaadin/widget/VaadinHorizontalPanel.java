package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Style;
import com.vaadin.ui.HorizontalLayout;

public class VaadinHorizontalPanel extends VaadinContainer<HorizontalLayout>implements HorizontalPanel {
	public VaadinHorizontalPanel() {
		this(new HorizontalLayout());
		setStyle(Style.DEFAULT);
	}

	public VaadinHorizontalPanel(HorizontalLayout horizontalLayout) {
		super(horizontalLayout);
	}
}
