package com.aajtech.ui.vaadin.ioc;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.vaadin.widget.VaadinAbsolutePanel;
import com.aajtech.ui.vaadin.widget.VaadinButton;
import com.aajtech.ui.vaadin.widget.VaadinGridPanel;
import com.aajtech.ui.vaadin.widget.VaadinHorizontalPanel;
import com.aajtech.ui.vaadin.widget.VaadinImage;
import com.aajtech.ui.vaadin.widget.VaadinLabel;
import com.aajtech.ui.vaadin.widget.VaadinListWidget;
import com.aajtech.ui.vaadin.widget.VaadinPasswordBox;
import com.aajtech.ui.vaadin.widget.VaadinTextBox;
import com.aajtech.ui.vaadin.widget.VaadinVerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Button.class).to(VaadinButton.class);
		bind(Label.class).to(VaadinLabel.class);
		bind(TextBox.class).to(VaadinTextBox.class);
		bind(PasswordBox.class).to(VaadinPasswordBox.class);
		bind(HorizontalPanel.class).to(VaadinHorizontalPanel.class);
		bind(VerticalPanel.class).to(VaadinVerticalPanel.class);
		bind(GridPanel.class).to(VaadinGridPanel.class);
		bind(ListWidget.class).to(VaadinListWidget.class);
		bind(Image.class).to(VaadinImage.class);
		bind(AbsolutePanel.class).to(VaadinAbsolutePanel.class);
	}
}
