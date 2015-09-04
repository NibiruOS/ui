package com.aajtech.ui.vaadin.ioc;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.vaadin.widget.VaadinHorizontalPanel;
import com.aajtech.ui.vaadin.widget.VaadinLabel;
import com.aajtech.ui.vaadin.widget.VaadinTextBox;
import com.aajtech.ui.vaadin.widget.VaadinVerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(VaadinLabel.class);
		bind(TextBox.class).to(VaadinTextBox.class);
		bind(HorizontalPanel.class).to(VaadinHorizontalPanel.class);
		bind(VerticalPanel.class).to(VaadinVerticalPanel.class);
	}
}
