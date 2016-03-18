package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.GridPanel;

public class GridPanelBuilder extends BaseContainerBuilder<GridPanel, GridPanelBuilder> {
	@Inject
	private static Provider<GridPanelBuilder> gridPanelBuilderProvider;

	public static GridPanelBuilder gridPanel() {
		return gridPanelBuilderProvider.get();
	}

	public static GridPanelBuilder gridPanel(int columns) {
		return gridPanel().columns(columns);
	}

	@Inject
	public GridPanelBuilder(GridPanel gridPanel) {
		super(gridPanel);
	}

	public GridPanelBuilder columns(int columns) {
		object.setColumns(columns);
		return this;
	}
}
