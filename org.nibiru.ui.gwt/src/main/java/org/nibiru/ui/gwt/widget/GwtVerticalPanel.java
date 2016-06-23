package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.gwt.resource.Resources;

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
