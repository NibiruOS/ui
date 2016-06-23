package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnEditingChangedListener;
import org.robovm.apple.uikit.UITextBorderStyle;
import org.robovm.apple.uikit.UITextField;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.TextBox;
import com.google.common.base.Strings;

public class IOSTextBox extends IOSValueWidget<UITextField, String> implements TextBox {
	public IOSTextBox() {
		this(new UITextField(new CGRect(0, 0, 120, 30)));
	}

	public IOSTextBox(final UITextField textField) {
		super(textField);
		control.setBorderStyle(UITextBorderStyle.RoundedRect);
		textField.addOnEditingChangedListener(new OnEditingChangedListener() {
			@Override
			public void onEditingChanged(UIControl arg0) {
				getValue().notifyObservers();
			}
		});
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return Strings.nullToEmpty(control.getText());
			}

			@Override
			protected void setValue(String value) {
				control.setText(value);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}
}
