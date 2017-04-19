package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.GridPanel;

import javax.inject.Inject;

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
