package com.aajtech.ui.core.impl.builder;

import com.aajtech.model.core.impl.bind.Bind;
import com.aajtech.ui.core.api.ValueWidget;

abstract class BaseValueBuilder<T extends ValueWidget<V>, V, B extends BaseWidgetBuilder<T, ?>>
		extends BaseWidgetBuilder<T, B> {

	BaseValueBuilder(T control) {
		super(control);
	}

	public B value(V value) {
		object.getValue().set(value);
		return getThis();
	}

	public B addObserver(Runnable observer) {
		object.getValue().addObserver(observer);
		return getThis();
	}

	public Bind<V> bind() {
		return Bind.on(object.getValue());
	}
}
