package com.aajtech.ui.ios.widget;

import com.aajtech.ui.core.api.PasswordBox;

public class IOSPasswordBox extends IOSTextBox implements PasswordBox {
	public IOSPasswordBox() {
		control.setSecureTextEntry(true);
	}
}
