package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class TouchUpInsideHandlerRegistration implements HandlerRegistration {
	private final UIControl control;
	private final OnTouchUpInsideListener listener;

	public TouchUpInsideHandlerRegistration(UIControl control, OnTouchUpInsideListener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
	}

	@Override
	public void removeHandler() {
		control.removeListener(listener);
	}
}
