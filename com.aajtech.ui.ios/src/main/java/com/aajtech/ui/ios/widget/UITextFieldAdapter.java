package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl.OnValueChangedListener;
import org.robovm.apple.uikit.UITextField;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;

import com.google.common.base.Strings;

public class UITextFieldAdapter implements HasValue<String> {
	private final UITextField textField;

	public UITextFieldAdapter(UITextField textField) {
		this.textField = checkNotNull(textField);
	}

	@Override
	public void setValue(String value) {
		textField.setText(value);
	}

	@Override
	public String getValue() {
		return Strings.nullToEmpty(textField.getText());
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		//TODO: this is not working!!!
		OnValueChangedListener listener = new ChangeHandlerAdapter(
				changeHandler);
		textField.addOnValueChangedListener(listener);
		return new ValueChangedHandlerRegistration(textField, listener);
	}
}
