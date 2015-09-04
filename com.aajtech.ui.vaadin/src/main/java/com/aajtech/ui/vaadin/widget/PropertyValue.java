package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.vaadin.data.Property;

class PropertyValue<T> extends BaseValue<T> {
	private final Property<T> property;
	private final Type<T> type;

	PropertyValue(Property<T> property, Type<T> type) {
		this.property = property;
		this.type = type;
	}

	@Override
	public T get() {
		return property.getValue();
	}

	@Override
	public void set(T value) {
		property.setValue(value);
	}

	@Override
	public Type<T> getType() {
		return type;
	}
}
