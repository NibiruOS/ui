package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

abstract class BaseContainerBuilder<T extends Container, B extends BaseWidgetBuilder<T, ?>>
		extends BaseWidgetBuilder<T, B> {
	BaseContainerBuilder(T widget) {
		super(widget);
	}

	public B add(Widget child) {
		object.add(child);
		return getThis();
	}
}
