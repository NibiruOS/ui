package com.aajtech.ui.gwt.widget;

import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;
import com.google.gwt.user.client.ui.Panel;

class GwtContainer<T extends Panel> extends GwtWidget<T>implements Container {
	GwtContainer(T panel) {
		super(panel);
	}

	@Override
	public void add(Widget child) {
		widget.add((com.google.gwt.user.client.ui.Widget) child.asNative());
	}
}
