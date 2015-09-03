package com.aajtech.ui.showcase.vaadin.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinServlet;

public class ShowcaseServlet extends VaadinServlet implements SessionInitListener {
	private static final long serialVersionUID = 7854794111328513881L;
	private final Provider<UIProvider> uiProvider;

	@Inject
	public ShowcaseServlet(Provider<UIProvider> uiProvider) {
		this.uiProvider = checkNotNull(uiProvider);
	}

	@Override
	protected void servletInitialized() {
		getService().addSessionInitListener(this);
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		event.getSession().addUIProvider(uiProvider.get());
	}
}
