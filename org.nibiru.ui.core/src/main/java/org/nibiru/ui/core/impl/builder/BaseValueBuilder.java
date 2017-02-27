package org.nibiru.ui.core.impl.builder;

import org.nibiru.model.core.impl.bind.Bind;
import org.nibiru.ui.core.api.ValueWidget;

abstract public class BaseValueBuilder<T extends ValueWidget<V>, V, B extends BaseWidgetBuilder<T, ?>>
		extends BaseWidgetBuilder<T, B> {

	protected BaseValueBuilder(T control) {
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
