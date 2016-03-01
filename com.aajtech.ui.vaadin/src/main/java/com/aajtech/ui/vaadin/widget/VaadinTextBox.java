package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.TextStyle;
import com.vaadin.ui.TextField;

public class VaadinTextBox extends VaadinValueWidget<TextField, String>implements TextBox {
	public VaadinTextBox() {
		this(new TextField());
		component.setImmediate(true);
		component.setNullRepresentation("");
		setStyle(TextStyle.DEFAULT);
	}

	public VaadinTextBox(TextField textField) {
		super(textField, JavaType.STRING, textField.getValue());
	}
}