package com.aajtech.ui.core.impl.builder;

import com.aajtech.model.core.impl.bind.Bind;
import com.aajtech.ui.core.api.ValueWidget;

abstract class BaseValueBuilder<T extends ValueWidget<V>, V> extends BaseBuilder<T> {

	BaseValueBuilder(T widget) {
		super(widget);
	}

	public Bind<V> bind() {
		return Bind.on(object.getValue());
	}
}
