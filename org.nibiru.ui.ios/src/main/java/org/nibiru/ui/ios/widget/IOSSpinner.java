package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Spinner;

import apple.uikit.UIActivityIndicatorView;
import apple.uikit.enums.UIActivityIndicatorViewStyle;

public class IOSSpinner extends IOSWidget<UIActivityIndicatorView> implements Spinner {
	@Inject
	public IOSSpinner() {
		super(UIActivityIndicatorView.alloc().initWithActivityIndicatorStyle(UIActivityIndicatorViewStyle.WhiteLarge));
		control.startAnimating();
	}

	@Override
	protected int getNativeHeight() {
		// TODO Fix value - add size computation
		return 30;
	}

	@Override
	protected int getNativeWidth() {
		// TODO Fix value - add size computation
		return 30;
	}
}
