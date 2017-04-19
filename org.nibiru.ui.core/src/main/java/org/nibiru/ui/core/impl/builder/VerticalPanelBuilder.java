package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.VerticalPanel;

import javax.inject.Inject;

public class VerticalPanelBuilder extends BaseContainerBuilder<VerticalPanel, VerticalPanelBuilder> {
	@Inject
	public VerticalPanelBuilder(VerticalPanel verticalPanel) {
		super(verticalPanel);
	}
}
