package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

public class AbsolutePanelBuilder extends BaseWidgetBuilder<AbsolutePanel, AbsolutePanelBuilder> {
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
