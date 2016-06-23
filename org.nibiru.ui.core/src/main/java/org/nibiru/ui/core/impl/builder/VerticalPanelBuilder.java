package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.VerticalPanel;

public class VerticalPanelBuilder extends BaseContainerBuilder<VerticalPanel, VerticalPanelBuilder> {
	@Inject
	public VerticalPanelBuilder(VerticalPanel verticalPanel) {
		super(verticalPanel);
	}
}
