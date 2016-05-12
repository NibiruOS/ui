package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.PasswordBox;

public class IOSPasswordBox extends IOSTextBox implements PasswordBox {
	@Inject
	public IOSPasswordBox() {
		control.setSecureTextEntry(true);
	}
}
