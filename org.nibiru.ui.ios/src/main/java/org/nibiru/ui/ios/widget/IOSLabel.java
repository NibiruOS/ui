package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Label;

import apple.coregraphics.struct.CGSize;
import apple.foundation.NSString;
import apple.uikit.UILabel;

public class IOSLabel extends IOSValueWidget<UILabel, String> implements Label {
	@Inject
	public IOSLabel() {
		this(UILabel.alloc().init());
	}

	public IOSLabel(UILabel label) {
		super(label);
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return control.text();
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
		return (int) size().height();
	}

	@Override
	protected int getNativeWidth() {
		return (int) size().width();
	}

	private CGSize size() {
		return control.text() != null ? NSString.stringWithString(control.text()).sizeWithFont(control.font())
				: new CGSize(0, 0);
	}
}
