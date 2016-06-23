package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class BaseBuilder<T> implements Builder<T> {
	final T object;

	BaseBuilder(T object) {
		this.object = checkNotNull(object);
	}

	@Override
	public T build() {
		return object;
	}
}
