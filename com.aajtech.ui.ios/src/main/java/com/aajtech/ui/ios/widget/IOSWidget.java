package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.Widget;

abstract class IOSWidget<T extends UIView> implements Widget {
	final T control;

	IOSWidget(T control) {
		this.control = checkNotNull(control);
	}

	@Override
	public Object asNative() {
		return control;
	}
}
