package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;
import com.aajtech.ui.core.api.ValueWidget;

class BaseClickableValueBuilder<T extends ValueWidget<V> & HasClickHandler, V, B extends BaseWidgetBuilder<T, ?>>
		extends BaseValueBuilder<T, V, B> {

	BaseClickableValueBuilder(T control) {
		super(control);
	}

	public B onClick(ClickHandler clickHandler) {
		object.setClickHandler(clickHandler);
		return getThis();
	}
}
