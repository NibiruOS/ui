package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Registration;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;

public class TouchUpInsideHandlerRegistration implements Registration {
	private final UIControl control;
	private final OnTouchUpInsideListener listener;

	public TouchUpInsideHandlerRegistration(UIControl control, OnTouchUpInsideListener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
		control.addOnTouchUpInsideListener(listener);
	}

	@Override
	public void remove() {
		control.removeListener(listener);
	}
}
