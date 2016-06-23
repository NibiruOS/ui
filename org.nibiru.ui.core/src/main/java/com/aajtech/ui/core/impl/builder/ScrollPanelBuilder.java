package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.ScrollPanel;
import com.aajtech.ui.core.api.Widget;

public class ScrollPanelBuilder extends BaseWidgetBuilder<ScrollPanel, ScrollPanelBuilder> {
	@Inject
	public ScrollPanelBuilder(ScrollPanel control) {
		super(control);
	}

	public ScrollPanelBuilder content(Widget content) {
		object.setContent(content);
		return this;
	}

	public ScrollPanel build(Widget content) {
		return content(content).build();
	}
}
