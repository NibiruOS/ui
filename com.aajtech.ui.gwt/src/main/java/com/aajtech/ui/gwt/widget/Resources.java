package com.aajtech.ui.gwt.widget;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle {
	@Source("nibiru.css")
	Css css();

	public interface Css extends CssResource {
		String popupGlass();
	}
}
