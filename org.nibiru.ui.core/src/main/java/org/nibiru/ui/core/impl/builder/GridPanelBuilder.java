package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.GridPanel;

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
