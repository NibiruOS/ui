package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.ScrollPanel;
import com.aajtech.ui.core.api.Widget;

public class ScrollPanelBuilder extends BaseWidgetBuilder<ScrollPanel, ScrollPanelBuilder> {
	@Inject
	private static Provider<ScrollPanelBuilder> scrollPanelBuilderProvider;

	public static ScrollPanelBuilder scrollPanel() {
		return scrollPanelBuilderProvider.get();
	}

	public static ScrollPanel scrollPanel(Widget content) {
		return scrollPanel().content(content).build();
	}

	@Inject
	public ScrollPanelBuilder(ScrollPanel control) {
		super(control);
	}

	public ScrollPanelBuilder content(Widget content) {
		object.setContent(content);
		return this;
	}
}
