package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.user.client.ui.TextBox;

public class GwtTextBox extends GwtHasValueWidget<TextBox, String>implements org.nibiru.ui.core.api.TextBox {
	@Inject
	public GwtTextBox() {
		this(new TextBox());
	}

	public GwtTextBox(TextBox textBox) {
		super(textBox, JavaType.STRING);
	}
}
