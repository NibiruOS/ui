package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

import apple.uikit.UIView;

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
