package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Spinner;

import ios.uikit.UIView;

public class IOSSpinner extends IOSWidget<UIView> implements Spinner {
	@Inject
	public IOSSpinner() {
		super(UIView.alloc().init());
	}
}
