package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.HorizontalPanel;

public class HorizontalPanelBuilder extends BaseContainerBuilder<HorizontalPanel, HorizontalPanelBuilder> {
	@Inject
	public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
		super(horizontalPanel);
	}
}
