package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Style;
import com.aajtech.ui.core.api.Widget;

public class HorizontalPanelBuilder extends BaseBuilder<HorizontalPanel> {
	@Inject
	public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
		super(horizontalPanel);
	}

	public HorizontalPanelBuilder add(Widget child) {
		object.add(child);
		return this;
	}
	
	public HorizontalPanelBuilder style(Style style) {
		object.setStyle(style);
		return this;
	}
}
