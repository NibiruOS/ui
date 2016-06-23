package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.user.client.ui.PasswordTextBox;

public class GwtPasswordBox extends GwtHasValueWidget<PasswordTextBox, String> implements org.nibiru.ui.core.api.PasswordBox {
	@Inject
	public GwtPasswordBox() {
		this(new PasswordTextBox());
	}

	public GwtPasswordBox(PasswordTextBox passwordTextBox) {
		super(passwordTextBox, JavaType.STRING);
	}
}
