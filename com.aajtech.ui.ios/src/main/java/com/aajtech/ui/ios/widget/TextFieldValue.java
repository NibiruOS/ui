package com.aajtech.ui.ios.widget;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnValueChangedListener;
import org.robovm.apple.uikit.UITextField;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.common.base.Strings;

class TextFieldValue extends BaseValue<String> {
	private final UITextField textField;

	TextFieldValue(UITextField textField) {
		this.textField = textField;
		//TODO: Check if this is working
		textField.addOnValueChangedListener(new OnValueChangedListener() {
			@Override
			public void onValueChanged(UIControl arg0) {
				notifyObservers();
			}
		});
	}

	@Override
	public String get() {
		return Strings.nullToEmpty(textField.getText());
	}

	@Override
	protected void setValue(String value) {
		textField.setText(value);
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}
