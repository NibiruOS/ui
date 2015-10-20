package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UILabel;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

public class UILabelAdapter implements TakesValue<String> {
	private final UILabel label;

	public UILabelAdapter(UILabel label) {
		this.label = checkNotNull(label);
	}

	@Override
	public void setValue(String value) {
		label.setText(value);
	}

	@Override
	public String getValue() {
		return label.getText();
	}

}
