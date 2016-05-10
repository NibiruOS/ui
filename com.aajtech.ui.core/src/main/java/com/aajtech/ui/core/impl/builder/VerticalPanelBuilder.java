package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.VerticalPanel;

public class VerticalPanelBuilder extends BaseContainerBuilder<VerticalPanel, VerticalPanelBuilder> {
	@Inject
	private static Provider<VerticalPanelBuilder> verticalPanelBuilderProvider;

	public static VerticalPanelBuilder verticalPanel() {
		return verticalPanelBuilderProvider.get();
	}

	@Inject
	public VerticalPanelBuilder(VerticalPanel verticalPanel) {
		super(verticalPanel);
	}
}
