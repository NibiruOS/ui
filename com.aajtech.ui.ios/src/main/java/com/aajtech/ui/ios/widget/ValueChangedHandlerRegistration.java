package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnValueChangedListener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class ValueChangedHandlerRegistration implements HandlerRegistration {
	private final UIControl control;
	private final OnValueChangedListener listener;

	public ValueChangedHandlerRegistration(UIControl control,
			OnValueChangedListener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
	}

	@Override
	public void removeHandler() {
		control.removeListener(listener);
	}
}
