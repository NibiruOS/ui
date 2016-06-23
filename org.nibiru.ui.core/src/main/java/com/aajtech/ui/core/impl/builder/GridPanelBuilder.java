package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.GridPanel;

public class GridPanelBuilder extends BaseContainerBuilder<GridPanel, GridPanelBuilder> {
	@Inject
	public GridPanelBuilder(GridPanel gridPanel) {
		super(gridPanel);
	}

	public GridPanelBuilder columns(int columns) {
		object.setColumns(columns);
		return this;
	}
}
