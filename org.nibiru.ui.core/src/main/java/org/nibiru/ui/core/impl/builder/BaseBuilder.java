package org.nibiru.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseBuilder<T> implements Builder<T> {
	protected final T object;

	protected BaseBuilder(T object) {
		this.object = checkNotNull(object);
	}

	@Override
	public T build() {
		return object;
	}
}
