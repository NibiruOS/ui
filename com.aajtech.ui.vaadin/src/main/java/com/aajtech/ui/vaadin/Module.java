package com.aajtech.ui.vaadin;

import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.VerticalPanel;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Label.class).to(VaadinLabel.class);
		bind(VerticalPanel.class).to(VaadinVerticalPanel.class);
	}
}
