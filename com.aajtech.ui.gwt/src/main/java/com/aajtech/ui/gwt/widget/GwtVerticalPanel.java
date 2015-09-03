package com.aajtech.ui.gwt.widget;

import com.aajtech.ui.core.api.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtVerticalPanel implements com.aajtech.ui.core.api.VerticalPanel {
	private final VerticalPanel panel = new VerticalPanel();

	@Override
	public void add(Widget widget) {
		panel.add((com.google.gwt.user.client.ui.Widget) widget.asNative());
	}

	@Override
	public Object asNative() {
		return panel;
	}
}
