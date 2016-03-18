package org.nibiru.ui.vaadin.widget;

import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TextBox;
import com.vaadin.ui.TextField;

public class VaadinTextBox extends VaadinValueWidget<TextField, String>implements TextBox {
	public VaadinTextBox() {
		this(new TextField());
		control.setImmediate(true);
		control.setNullRepresentation("");
		setWidth(150);
		setHeight(25);
	}

	public VaadinTextBox(TextField textField) {
		super(textField, JavaType.STRING, textField.getValue());
	}
}