package com.aajtech.ui.showcase.gwt.app;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class AppEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {
		Injector injector = GWT.create(Injector.class);
		
		RootPanel.get().add((Widget) injector.mainPage().buildUi().asNative());
	}
}
