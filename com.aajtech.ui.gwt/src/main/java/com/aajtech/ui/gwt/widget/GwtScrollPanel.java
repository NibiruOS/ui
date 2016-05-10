package com.aajtech.ui.gwt.widget;

import com.aajtech.ui.core.api.Widget;
import com.google.gwt.user.client.ui.ScrollPanel;

public class GwtScrollPanel extends GwtWidget<ScrollPanel>implements com.aajtech.ui.core.api.ScrollPanel {
	public GwtScrollPanel() {
		this(new ScrollPanel());
	}

	public GwtScrollPanel(ScrollPanel control) {
		super(control);
	}

	@Override
	public void setContent(Widget content) {
		control.clear();
		control.add((com.google.gwt.user.client.ui.Widget) content.asNative());
	}
}
