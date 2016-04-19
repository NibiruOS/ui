package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.TextBox;

public class GwtTextBox extends GwtValueWidget<TextBox, String>implements com.aajtech.ui.core.api.TextBox {
	public GwtTextBox() {
		this(new TextBox());
	}

	public GwtTextBox(TextBox textBox) {
		super(textBox, JavaType.STRING);
	}
}
