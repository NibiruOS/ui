package com.aajtech.ui.gwt.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	@Source("styles.css")
	Css css();

	@Source("spinner.gif")
	ImageResource spinner();

	public interface Css extends CssResource {
		String popupGlass();
	}
}
