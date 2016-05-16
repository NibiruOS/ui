package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.VerticalPanel;

public class VerticalPanelBuilder extends BaseContainerBuilder<VerticalPanel, VerticalPanelBuilder> {
	@Inject
	public VerticalPanelBuilder(VerticalPanel verticalPanel) {
		super(verticalPanel);
	}
}
