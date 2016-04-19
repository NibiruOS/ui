package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class GwtPasswordBox extends GwtValueWidget<PasswordTextBox, String> implements com.aajtech.ui.core.api.PasswordBox {
	public GwtPasswordBox() {
		this(new PasswordTextBox());
	}

	public GwtPasswordBox(PasswordTextBox passwordTextBox) {
		super(passwordTextBox, JavaType.STRING);
	}
}
