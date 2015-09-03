package com.aajtech.ui.showcase.gwt.app;

import com.aajtech.ui.gwt.ioc.Module;
import com.aajtech.ui.showcase.app.MainPage;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ Module.class })
public interface Injector extends Ginjector {
	MainPage mainPage();
}
