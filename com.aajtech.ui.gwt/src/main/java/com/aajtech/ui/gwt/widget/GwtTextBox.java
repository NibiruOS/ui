package com.aajtech.ui.gwt.widget;

import javax.inject.Inject;

import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.TextBox;

public class GwtTextBox extends GwtHasValueWidget<TextBox, String>implements com.aajtech.ui.core.api.TextBox {
	@Inject
	public GwtTextBox() {
		this(new TextBox());
	}

	public GwtTextBox(TextBox textBox) {
		super(textBox, JavaType.STRING);
	}
}
