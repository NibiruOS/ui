package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HorizontalPanel;

import javax.inject.Inject;

public class HorizontalPanelBuilder extends BaseContainerBuilder<HorizontalPanel, HorizontalPanelBuilder> {
	@Inject
	public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
		super(horizontalPanel);
	}
}
