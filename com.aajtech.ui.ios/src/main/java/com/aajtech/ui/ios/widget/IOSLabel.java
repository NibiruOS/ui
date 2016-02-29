package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.coregraphics.CGSize;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UILabel;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.Label;

public class IOSLabel extends IOSValueWidget<UILabel, String> implements Label {
	public IOSLabel() {
		this(new UILabel(new CGRect(0, 0, 120, 30)));
	}

	public IOSLabel(UILabel label) {
		super(label);
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return control.getText();
			}

			@Override
			protected void setValue(String value) {
				control.setText(value);
				CGSize size = new NSString(value).getSize(control.getFont());
				updateSize(size.getWidth(), size.getHeight());
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}
}
