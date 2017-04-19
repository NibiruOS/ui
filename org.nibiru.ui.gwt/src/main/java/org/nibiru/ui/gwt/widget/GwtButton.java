package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.Button;

import org.nibiru.model.core.api.Value;

import javax.inject.Inject;

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
