package com.aajtech.ui.gwt.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.gwt.resource.Resources;
import com.google.gwt.user.client.ui.FlowPanel;

public class GwtVerticalPanel extends GwtContainer<FlowPanel> implements VerticalPanel {
	@Inject
	public GwtVerticalPanel(Resources resources) {
		this(new FlowPanel());
		control.addStyleName(resources.css().verticalPanel());
	}

	public GwtVerticalPanel(FlowPanel control) {
		super(control);
	}
}
