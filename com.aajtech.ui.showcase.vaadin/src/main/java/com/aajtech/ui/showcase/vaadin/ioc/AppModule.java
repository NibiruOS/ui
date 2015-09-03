package com.aajtech.ui.showcase.vaadin.ioc;

import javax.inject.Singleton;

import com.aajtech.ui.showcase.vaadin.ui.ShowcaseUiProvider;
import com.google.inject.AbstractModule;
import com.vaadin.server.UIProvider;

public class AppModule extends AbstractModule {
	static final String PERSISTENCE_UNIT = "HR";

	@Override
	protected void configure() {
		requestStaticInjection(SerializableProvider.class);

		// UI
		bind(UIProvider.class).to(ShowcaseUiProvider.class).in(Singleton.class);
	}
}
