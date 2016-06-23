package org.nibiru.ui.vaadin.widget;

import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.PasswordBox;

import com.vaadin.ui.PasswordField;

public class VaadinPasswordBox extends VaadinValueWidget<PasswordField, String>implements PasswordBox {
	public VaadinPasswordBox() {
		this(new PasswordField());
		control.setImmediate(true);
		control.setNullRepresentation("");
	}

	public VaadinPasswordBox(PasswordField passwordField) {
		super(passwordField, JavaType.STRING, passwordField.getValue());
	}
}