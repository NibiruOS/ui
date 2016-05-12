package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Label;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.NSString;
import ios.uikit.UILabel;

public class IOSLabel extends IOSValueWidget<UILabel, String> implements Label {
	@Inject
	public IOSLabel() {
		this(buildLabel());
	}

	private static UILabel buildLabel() {
		UILabel label = UILabel.alloc().init();
		label.setFrame(new CGRect(new CGPoint(0, 0), new CGSize(120, 30)));
		return label;
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
				CGSize size = NSString.stringWithString(value).sizeWithFont(control.font());
				updateSize(size.width(), size.height());
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
