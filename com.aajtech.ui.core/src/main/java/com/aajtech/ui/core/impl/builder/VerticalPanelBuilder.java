package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.api.Widget;

public class VerticalPanelBuilder extends BaseBuilder<VerticalPanel> {
	@Inject
	public VerticalPanelBuilder(VerticalPanel verticalPanel) {
		super(verticalPanel);
	}

	public VerticalPanelBuilder add(Widget child) {
		widget.add(child);
		return this;
	}
}
