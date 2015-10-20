package com.aajtech.ui.android.ioc;

import com.aajtech.ui.android.widget.AndroidHorizontalPanel;
import com.aajtech.ui.android.widget.AndroidLabel;
import com.aajtech.ui.android.widget.AndroidTextBox;
import com.aajtech.ui.android.widget.AndroidVerticalPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(AndroidLabel.class);
		bind(TextBox.class).to(AndroidTextBox.class);
		bind(HorizontalPanel.class).to(AndroidHorizontalPanel.class);
		bind(VerticalPanel.class).to(AndroidVerticalPanel.class);
	}
}
