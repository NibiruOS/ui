package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.PasswordBox;

import javax.inject.Inject;

public class IOSPasswordBox extends IOSTextBox implements PasswordBox {
	@Inject
	public IOSPasswordBox() {
		control.setSecureTextEntry(true);
	}
}
