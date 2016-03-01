package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextStyle;
import com.vaadin.ui.PasswordField;

public class VaadinPasswordBox extends VaadinValueWidget<PasswordField, String>implements PasswordBox {
	public VaadinPasswordBox() {
		this(new PasswordField());
		component.setImmediate(true);
		component.setNullRepresentation("");
		setStyle(TextStyle.DEFAULT);
	}

	public VaadinPasswordBox(PasswordField passwordField) {
		super(passwordField, JavaType.STRING, passwordField.getValue());
	}
}