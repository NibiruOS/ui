package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.Size;

abstract class BaseWidgetBuilder<T extends Widget, B extends BaseWidgetBuilder<T, ?>> extends BaseBuilder<T> {

	BaseWidgetBuilder(T control) {
		super(control);
	}

	public B styleClass(Enum<?> styleClass) {
		object.setStyleName(styleClass);
		return getThis();
	}
	
	public B width(Size width) {
		object.setWidth(width);
		return getThis();
	}

	public B height(Size height) {
		object.setHeight(height);
		return getThis();
	}

	@SuppressWarnings("unchecked")
	B getThis() {
		return (B) this;
	}
}