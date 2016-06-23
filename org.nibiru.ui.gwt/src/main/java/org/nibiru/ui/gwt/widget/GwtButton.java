package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;

import com.google.gwt.user.client.ui.Button;

public class GwtButton extends GwtClickableValueWidget<Button, String> implements org.nibiru.ui.core.api.Button {
	@Inject
	public GwtButton() {
		this(new Button());
	}

	public GwtButton(Button button) {
		super(button);
	}

	@Override
	Value<String> buildValue() {
		return new HasTextAdapter(control);
	}
}
