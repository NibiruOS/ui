package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIEvent;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;

public class ClickHandlerAdapter implements OnTouchUpInsideListener {
	private final ClickHandler clickHandler;

	public ClickHandlerAdapter(ClickHandler clickHandler) {
		this.clickHandler = checkNotNull(clickHandler);
	}

	@Override
	public void onTouchUpInside(UIControl control, UIEvent event) {
		clickHandler.onClick();
	}
}
