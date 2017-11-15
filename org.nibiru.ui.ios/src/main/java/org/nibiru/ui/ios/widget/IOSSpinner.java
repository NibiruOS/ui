package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.Spinner;

import javax.inject.Inject;

import apple.uikit.UIActivityIndicatorView;
import apple.uikit.enums.UIActivityIndicatorViewStyle;

public class IOSSpinner extends IOSWidget<UIActivityIndicatorView> implements Spinner {
	@Inject
	public IOSSpinner() {
		super(UIActivityIndicatorView.alloc().initWithActivityIndicatorStyle(UIActivityIndicatorViewStyle.Gray));
		control.startAnimating();
	}

	@Override
	protected int getNativeHeight() {
		return 32;
	}

	@Override
	protected int getNativeWidth() {
		return 32;
	}
}
