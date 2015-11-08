package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;

import com.aajtech.model.core.api.Registration;

public class TouchUpInsideHandlerRegistration implements Registration {
	private final UIControl control;
	private final OnTouchUpInsideListener listener;

	public TouchUpInsideHandlerRegistration(UIControl control, OnTouchUpInsideListener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
	}

	@Override
	public void remove() {
		control.removeListener(listener);
	}
}
