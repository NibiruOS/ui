package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Button;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UIButton;
import apple.uikit.UIColor;
import apple.uikit.enums.UIButtonType;
import apple.uikit.enums.UIControlState;

public class IOSButton extends IOSValueWidget<UIButton, String> implements Button {
	private static final int MARGIN = 10;

	@Inject
	public IOSButton() {
		this(buildButton());
	}
	
	private static UIButton buildButton() {
		UIButton button = UIButton.buttonWithType(UIButtonType.RoundedRect);
		button.setFrame(new CGRect(new CGPoint(0, 0), new CGSize(120, 30)));
		button.setTitleColorForState(UIColor.blackColor(), UIControlState.Normal);
		button.setBackgroundColor(UIColor.grayColor());
		return button;
	}

	public IOSButton(UIButton button) {
		super(button);
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return control.titleForState(UIControlState.Normal);
			}

			@Override
			protected void setValue(String value) {
				control.setTitleForState(value, UIControlState.Normal);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	@Override
	protected int getNativeHeight() {
		return (int) (control.titleForState(UIControlState.Normal) != null ? size().height() : 0) + MARGIN;
	}

	@Override
	protected int getNativeWidth() {
		return (int) (control.titleForState(UIControlState.Normal) != null ? size().width() : 0) + MARGIN;
	}
	
	private CGSize size() {
		return sizeFromText(control.titleForState(UIControlState.Normal), control.font());
	}
}
