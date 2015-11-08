package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIView;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;

abstract class IOSValueWidget<T extends UIView> extends IOSWidget<T> implements ValueWidget<String> {
	private final Value<String> value;

	IOSValueWidget(ViewValue<T> value) {
		super(value.view);
		this.value = checkNotNull(value);
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
