package org.nibiru.ui.ios.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UITextField;
import apple.uikit.enums.UITextBorderStyle;

public class IOSTextBox extends IOSValueWidget<UITextField, String> implements TextBox {
	// TODO: Fix this "magic".
	private static int MAGIC_WIDTH_PADDING = 20;
	private static int MAGIC_HEIGHT_PADDING = 6;

	@Inject
	public IOSTextBox() {
		this(UITextField.alloc().initWithFrame(new CGRect(new CGPoint(0, 0), new CGSize(120, 30))));
	}

	public IOSTextBox(final UITextField textField) {
		super(textField);
		control.setBorderStyle(UITextBorderStyle.RoundedRect);
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

	@Override
	protected int getNativeHeight() {
		return (int) size().height()+ MAGIC_HEIGHT_PADDING;
	}

	@Override
	protected int getNativeWidth() {
		return (int) size().width() + MAGIC_WIDTH_PADDING;
	}

	private CGSize size() {
		return sizeFromText(control.text(), control.font());
	}
}
