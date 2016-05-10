package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Widget;

public class AbsolutePanelBuilder extends BaseWidgetBuilder<AbsolutePanel, AbsolutePanelBuilder> {
	@Inject
	private static Provider<AbsolutePanelBuilder> absolutePanelBuilderProvider;

	public static AbsolutePanelBuilder absolutePanel() {
		return absolutePanelBuilderProvider.get();
	}

	@Inject
	public AbsolutePanelBuilder(AbsolutePanel control) {
		super(control);
	}

	public AbsolutePanelBuilder add(int x, int y, Widget child) {
		object.add(child);
		object.getPosition(child).setX(x).setY(y);
		return this;
	}
}
