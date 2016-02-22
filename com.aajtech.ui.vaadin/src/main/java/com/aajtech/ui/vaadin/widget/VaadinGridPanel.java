package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.GridPanel;
import com.vaadin.ui.GridLayout;

public class VaadinGridPanel extends VaadinContainer<GridLayout>implements GridPanel {
	public VaadinGridPanel() {
		this(new GridLayout());
	}

	public VaadinGridPanel(GridLayout gridLayout) {
		super(gridLayout);
	}

	@Override
	public void setColumns(int columns) {
		component.setColumns(columns);
	}

	@Override
	public void setRows(int rows) {
		component.setRows(rows);
	}
}
