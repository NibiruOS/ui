package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.PasswordBox;

public class IOSPasswordBox extends IOSTextBox implements PasswordBox {
	public IOSPasswordBox() {
		control.setSecureTextEntry(true);
	}
}
