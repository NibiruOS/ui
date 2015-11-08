package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;

public class IOSButton extends IOSValueWidget<UIButton> implements Button {
	public IOSButton() {
		super(new ViewValue<UIButton>(new UIButton(new CGRect(0, 0, 120, 30))) {
			@Override
			public String get() {
				return view.getTitle(UIControlState.Normal);
			}

			@Override
			protected void setValue(String value) {
				view.setTitle(value, UIControlState.Normal);
			}
		});
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
}
