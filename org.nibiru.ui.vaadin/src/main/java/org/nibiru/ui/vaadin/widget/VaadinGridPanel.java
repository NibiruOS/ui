package org.nibiru.ui.vaadin.widget;

import org.nibiru.ui.core.api.GridPanel;

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
		control.setColumns(columns);
	}
}
