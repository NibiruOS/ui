package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Value;
import com.google.gwt.user.client.ui.Button;

public class GwtButton extends GwtClickableValueWidget<Button, String> implements com.aajtech.ui.core.api.Button {
	
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
