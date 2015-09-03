package com.aajtech.ui.showcase.vaadin.ioc;

import javax.inject.Singleton;

import com.aajtech.ui.showcase.vaadin.ui.ShowcaseServlet;

public class ServletModule extends com.google.inject.servlet.ServletModule {
	public static final String UI_PATH = "/ui";

	@Override
	protected void configureServlets() {
		bind(ShowcaseServlet.class).in(Singleton.class);
		serve(UI_PATH, UI_PATH + "/*", "/VAADIN/*", "/UIDL/*").with(
				ShowcaseServlet.class);

	}
}