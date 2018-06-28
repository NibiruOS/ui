package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.Image;

import org.nibiru.ui.core.api.Spinner;
import org.nibiru.ui.gwt.resource.Resources;

import javax.inject.Inject;

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
