package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;

abstract public class BaseContainerBuilder<T extends Container, B extends BaseWidgetBuilder<T, ?>>
		extends BaseWidgetBuilder<T, B> {
	BaseContainerBuilder(T widget) {
		super(widget);
	}

	public B add(Widget child) {
		object.add(child);
		return getThis();
	}
}
