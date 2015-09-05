package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.vaadin.ui.HorizontalLayout;

public class VaadinHorizontalPanel extends VaadinContainer<HorizontalLayout>implements HorizontalPanel {
	private static final long serialVersionUID = -133243684384988562L;

	public VaadinHorizontalPanel() {
		super(new HorizontalLayout());
	}
}
