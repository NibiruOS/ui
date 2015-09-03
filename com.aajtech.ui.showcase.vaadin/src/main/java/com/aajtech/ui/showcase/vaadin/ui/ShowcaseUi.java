package com.aajtech.ui.showcase.vaadin.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.showcase.app.MainPage;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class ShowcaseUi extends UI {
	private static final long serialVersionUID = -4200798947384856239L;
	private final MainPage mainPage;

	@Inject
	public ShowcaseUi(MainPage mainPage) {
		this.mainPage = checkNotNull(mainPage);
	}

	@Override
	protected void init(VaadinRequest request) {
		setContent((Component) mainPage.buildPage());
	}
}
