package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

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
