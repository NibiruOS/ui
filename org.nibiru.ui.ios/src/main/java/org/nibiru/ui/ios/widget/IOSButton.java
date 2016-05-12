package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.NSString;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlState;

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
	public Registration setClickHandler(ClickHandler clickHandler) {
		return new TouchUpInsideHandlerRegistration(control, clickHandler);
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
				CGSize size = NSString.stringWithString(value).sizeWithFont(control.titleLabel().font());
				updateSize(size.width() + MARGIN, size.height() + MARGIN);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}
}
