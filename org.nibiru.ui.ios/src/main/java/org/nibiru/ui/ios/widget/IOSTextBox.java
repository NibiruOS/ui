package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TextBox;

import com.google.common.base.Strings;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UITextField;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UITextBorderStyle;

public class IOSTextBox extends IOSValueWidget<UITextField, String> implements TextBox {
	@Inject
	public IOSTextBox() {
		this(UITextField.alloc().initWithFrame(new CGRect(new CGPoint(0, 0), new CGSize(120, 30))));
	}

	public IOSTextBox(final UITextField textField) {
		super(textField);
		control.setBorderStyle(UITextBorderStyle.RoundedRect);
		textField.addTargetActionForControlEvents((Object var1, long var2) -> {
			getValue().notifyObservers();
		}, UIControlEvents.EditingChanged);
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return Strings.nullToEmpty(control.text());
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
