package com.aajtech.ui.ios.ioc;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.impl.GridPanelImpl;
import com.aajtech.ui.core.impl.HorizontalPanelImpl;
import com.aajtech.ui.core.impl.VerticalPanelImpl;
import com.aajtech.ui.ios.widget.IOSButton;
import com.aajtech.ui.ios.widget.IOSImage;
import com.aajtech.ui.ios.widget.IOSLabel;
import com.aajtech.ui.ios.widget.IOSListWidget;
import com.aajtech.ui.ios.widget.IOSPasswordBox;
import com.aajtech.ui.ios.widget.IOSTextBox;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(IOSLabel.class);
		bind(TextBox.class).to(IOSTextBox.class);
		bind(PasswordBox.class).to(IOSPasswordBox.class);
		bind(Button.class).to(IOSButton.class);
		bind(ListWidget.class).to(IOSListWidget.class);
		bind(Image.class).to(IOSImage.class);

		// Generic bindings
		bind(VerticalPanel.class).to(VerticalPanelImpl.class);
		bind(HorizontalPanel.class).to(HorizontalPanelImpl.class);
		bind(GridPanel.class).to(GridPanelImpl.class);
	}
}
