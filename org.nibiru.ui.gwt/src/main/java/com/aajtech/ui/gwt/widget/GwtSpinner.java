package com.aajtech.ui.gwt.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Spinner;
import com.aajtech.ui.gwt.resource.Resources;
import com.google.gwt.user.client.ui.Image;

public class GwtSpinner extends GwtWidget<Image> implements Spinner {
	@Inject
	public GwtSpinner(Resources resources) {
		super(new Image());
		control.setResource(resources.spinner());
	}

	public GwtSpinner(Image control) {
		super(control);
	}
}
