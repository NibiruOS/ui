package com.aajtech.ui.ios.ioc;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(GwtLabel.class);
		bind(TextBox.class).to(GwtTextBox.class);
		bind(HorizontalPanel.class).to(GwtHorizontalPanel.class);
		bind(VerticalPanel.class).to(GwtVerticalPanel.class);
	}
}
