package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.ValueWidget;

public class BaseClickableValueBuilder<T extends ValueWidget<V> & HasClickHandler, V, B extends BaseWidgetBuilder<T, ?>>
		extends BaseValueBuilder<T, V, B> {

	protected BaseClickableValueBuilder(T control) {
		super(control);
	}

	public B onClick(ClickHandler clickHandler) {
		object.setClickHandler(clickHandler);
		return getThis();
	}
}
