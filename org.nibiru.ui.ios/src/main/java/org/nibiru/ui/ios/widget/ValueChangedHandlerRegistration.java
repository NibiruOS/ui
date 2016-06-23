package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Registration;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnValueChangedListener;

public class ValueChangedHandlerRegistration implements Registration {
	private final UIControl control;
	private final OnValueChangedListener listener;

	public ValueChangedHandlerRegistration(UIControl control,
			OnValueChangedListener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
	}

	@Override
	public void remove() {
		control.removeListener(listener);
	}
}
