package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Widget;

import com.google.gwt.user.client.ui.ScrollPanel;

public class GwtScrollPanel extends GwtWidget<ScrollPanel>implements org.nibiru.ui.core.api.ScrollPanel {
	@Inject
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
