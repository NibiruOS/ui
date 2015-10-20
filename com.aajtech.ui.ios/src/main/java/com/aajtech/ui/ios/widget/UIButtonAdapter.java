package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;

public class UIButtonAdapter implements HasClickHandler {
	private final UIButton button;

	public UIButtonAdapter(UIButton button) {
		this.button = checkNotNull(button);
	}

	@Override
	public HandlerRegistration setClickHandler(ClickHandler clickHandler) {
		OnTouchUpInsideListener listener = new ClickHandlerAdapter(clickHandler);
		button.addOnTouchUpInsideListener(listener);
		return new TouchUpInsideHandlerRegistration(button, listener);
	}
}
