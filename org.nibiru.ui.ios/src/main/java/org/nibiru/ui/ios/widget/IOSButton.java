package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.coregraphics.CGSize;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;

public class IOSButton extends IOSValueWidget<UIButton, String> implements Button {
	private static final int MARGIN = 10;

	public IOSButton() {
		this(new UIButton(new CGRect(0, 0, 120, 30)));
	}

	public IOSButton(UIButton button) {
		super(button);
		button.setTitleColor(UIColor.black(), UIControlState.Normal);
		button.setBackgroundColor(UIColor.gray());
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		return new TouchUpInsideHandlerRegistration(control, new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				clickHandler.onClick();
			}
		});
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			@Override
			public String get() {
				return control.getTitle(UIControlState.Normal);
			}

			@Override
			protected void setValue(String value) {
				control.setTitle(value, UIControlState.Normal);
				CGSize size = new NSString(value).getSize(control.getTitleLabel().getFont());
				updateSize(size.getWidth() + MARGIN, size.getHeight() + MARGIN);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}
}
