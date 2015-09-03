package com.aajtech.ui.showcase.vaadin.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.showcase.vaadin.ioc.SerializableProvider;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

public class ShowcaseUiProvider extends UIProvider {
	private static final long serialVersionUID = -5311985827648448144L;
	private final SerializableProvider<ShowcaseUi> provider;

	@Inject
	public ShowcaseUiProvider(SerializableProvider<ShowcaseUi> provider) {
		this.provider = checkNotNull(provider);
	}

	@Override
	public UI createInstance(UICreateEvent event) {
		return provider.get();
	}

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		return ShowcaseUi.class;
	}
}
