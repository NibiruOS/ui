package com.aajtech.ui.ios.ioc;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.ios.widget.IOSButton;
import com.aajtech.ui.ios.widget.IOSHorizontalPanel;
import com.aajtech.ui.ios.widget.IOSLabel;
import com.aajtech.ui.ios.widget.IOSTextBox;
import com.aajtech.ui.ios.widget.IOSVerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(IOSLabel.class);
		bind(TextBox.class).to(IOSTextBox.class);
		bind(HorizontalPanel.class).to(IOSHorizontalPanel.class);
		bind(VerticalPanel.class).to(IOSVerticalPanel.class);
		bind(Button.class).to(IOSButton.class);
	}
}
