package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.api.Widget;

abstract class BaseBuilder<T extends Widget> implements Builder<T> {
	final T widget;

	BaseBuilder(T widget) {
		this.widget = checkNotNull(widget);
	}

	@Override
	public T build() {
		return widget;
	}
}
