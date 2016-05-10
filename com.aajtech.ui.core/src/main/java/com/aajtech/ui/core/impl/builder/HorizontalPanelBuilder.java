package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.HorizontalPanel;

public class HorizontalPanelBuilder extends BaseContainerBuilder<HorizontalPanel, HorizontalPanelBuilder> {
	@Inject
	private static Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider;

	public static HorizontalPanelBuilder horizontalPanel() {
		return horizontalPanelBuilderProvider.get();
	}

	@Inject
	public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
		super(horizontalPanel);
	}
}
