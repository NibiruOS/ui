package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnValueChangedListener;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

public class ChangeHandlerAdapter implements OnValueChangedListener {
	private final ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		this.changeHandler = checkNotNull(changeHandler);
	}

	@Override
	public void onValueChanged(UIControl control) {
		changeHandler.onChange();
	}
}
