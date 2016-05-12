package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Checkbox;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.NSString;
import ios.uikit.UIButton;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlState;

public class IOSCheckbox extends IOSValueWidget<UIButton, Boolean> implements Checkbox {
	private static final int MARGIN = 10;
	private final Value<String> labelValue;
	private boolean checked;

	@Inject
	public IOSCheckbox() {
		super(buildButton());
		labelValue = new BaseValue<String>() {
			@Override
			public String get() {
				return control.titleForState(UIControlState.Normal);
			}

			@Override
			protected void setValue(String value) {
				control.setTitleForState(value, UIControlState.Normal);
				CGSize size = NSString.stringWithString(value).sizeWithFont(control.titleLabel().font());
				updateSize(size.width() + MARGIN, size.height() + MARGIN);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	private static UIButton buildButton() {
		UIButton button = UIButton.buttonWithType(UIButtonType.RoundedRect);
		button.setFrame(new CGRect(new CGPoint(0, 0), new CGSize(20, 20)));
		return button;
	}

	@Override
	public Value<String> getTextLabel() {
		return labelValue;
	}

	@Override
	Value<Boolean> buildValue() {
		return new BaseValue<Boolean>() {
			@Override
			public Boolean get() {
				return checked;
			}

			@Override
			protected void setValue(Boolean value) {
				checked = Boolean.TRUE.equals(value);
			}

			@Override
			public Type<Boolean> getType() {
				return JavaType.BOOLEAN;
			}
		};
	}
}
