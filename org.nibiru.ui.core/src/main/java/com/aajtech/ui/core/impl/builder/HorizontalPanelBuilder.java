package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.HorizontalPanel;

public class HorizontalPanelBuilder extends BaseContainerBuilder<HorizontalPanel, HorizontalPanelBuilder> {
	@Inject
	public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
		super(horizontalPanel);
	}
}
