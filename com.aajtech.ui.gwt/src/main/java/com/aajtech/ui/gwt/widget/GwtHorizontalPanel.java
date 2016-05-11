package com.aajtech.ui.gwt.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.gwt.resource.Resources;
import com.google.gwt.user.client.ui.FlowPanel;

public class GwtHorizontalPanel extends GwtContainer<FlowPanel> implements HorizontalPanel {
	@Inject
	public GwtHorizontalPanel(Resources resources) {
		this(new FlowPanel());
		control.addStyleName(resources.css().horizontalPanel());
	}

	public GwtHorizontalPanel(FlowPanel control) {
		super(control);
	}
}
