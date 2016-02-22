package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.Widget;

public class GridPanelBuilder extends BaseBuilder<GridPanel> {
	@Inject
	public GridPanelBuilder(GridPanel gridPanel) {
		super(gridPanel);
	}

	public GridPanelBuilder add(Widget child) {
		object.add(child);
		return this;
	}
}
