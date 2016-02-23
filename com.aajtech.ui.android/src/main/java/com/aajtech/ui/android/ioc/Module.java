package com.aajtech.ui.android.ioc;

import com.aajtech.ui.android.widget.AndroidButton;
import com.aajtech.ui.android.widget.AndroidGridPanel;
import com.aajtech.ui.android.widget.AndroidHorizontalPanel;
import com.aajtech.ui.android.widget.AndroidImage;
import com.aajtech.ui.android.widget.AndroidLabel;
import com.aajtech.ui.android.widget.AndroidListWidget;
import com.aajtech.ui.android.widget.AndroidPasswordBox;
import com.aajtech.ui.android.widget.AndroidTextBox;
import com.aajtech.ui.android.widget.AndroidVerticalPanel;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Button.class).to(AndroidButton.class);
		bind(Label.class).to(AndroidLabel.class);
		bind(TextBox.class).to(AndroidTextBox.class);
		bind(PasswordBox.class).to(AndroidPasswordBox.class);
		bind(HorizontalPanel.class).to(AndroidHorizontalPanel.class);
		bind(VerticalPanel.class).to(AndroidVerticalPanel.class);
		bind(GridPanel.class).to(AndroidGridPanel.class);
		bind(ListWidget.class).to(AndroidListWidget.class);
		bind(Image.class).to(AndroidImage.class);
	}
}
