package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UITextBorderStyle;
import org.robovm.apple.uikit.UITextField;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.TextBox;

public class IOSTextBox extends IOSWidget<UITextField> implements TextBox {
	private final Value<String> value;

	public IOSTextBox() {
		super(new UITextField(new CGRect(0, 0, 120, 30)));
		value = new TextFieldValue(control);
		control.setBorderStyle(UITextBorderStyle.RoundedRect);
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
