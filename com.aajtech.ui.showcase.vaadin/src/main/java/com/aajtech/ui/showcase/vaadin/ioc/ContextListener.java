package com.aajtech.ui.showcase.vaadin.ioc;

import com.aajtech.ui.vaadin.ioc.Module;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ContextListener extends GuiceServletContextListener {
	static final Injector injector = Guice.createInjector(new ServletModule(), new AppModule(), new Module());

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
