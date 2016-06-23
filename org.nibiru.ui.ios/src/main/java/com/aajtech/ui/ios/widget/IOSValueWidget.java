package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIView;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;

abstract class IOSValueWidget<T extends UIView, V> extends IOSWidget<T> implements ValueWidget<V> {
	private final Value<V> value;

	IOSValueWidget(T view) {
		super(view);
		this.value = checkNotNull(buildValue());
	}

	abstract Value<V> buildValue();
	
	@Override
	public Value<V> getValue() {
		return value;
	}
}
