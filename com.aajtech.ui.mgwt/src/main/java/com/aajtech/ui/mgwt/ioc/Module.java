package com.aajtech.ui.mgwt.ioc;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.gwt.widget.GwtButton;
import com.aajtech.ui.gwt.widget.GwtHorizontalPanel;
import com.aajtech.ui.gwt.widget.GwtLabel;
import com.aajtech.ui.gwt.widget.GwtTextBox;
import com.aajtech.ui.gwt.widget.GwtVerticalPanel;
import com.google.gwt.inject.client.AbstractGinModule;

public class Module extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(Label.class).to(GwtLabel.class);
		bind(TextBox.class).to(GwtTextBox.class);
		bind(HorizontalPanel.class).to(GwtHorizontalPanel.class);
		bind(VerticalPanel.class).to(GwtVerticalPanel.class);
		bind(Button.class).to(GwtButton.class);
	}
}
