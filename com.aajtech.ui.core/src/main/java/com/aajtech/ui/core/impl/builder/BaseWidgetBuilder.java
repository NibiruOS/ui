package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.Style;
import com.aajtech.ui.core.api.Widget;

abstract class BaseWidgetBuilder<T extends Widget, B extends BaseWidgetBuilder<T, ?>> extends BaseBuilder<T> {

	BaseWidgetBuilder(T widget) {
		super(widget);
	}

	public B style(Style style) {
		object.setStyle(style);
		return getThis();
	}
	
	@SuppressWarnings("unchecked")
	B getThis() {
		return (B) this;
	}
}