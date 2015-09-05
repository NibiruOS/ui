package com.aajtech.ui.vaadin.widget;

import java.io.Serializable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.ObjectProperty;

class PropertyValue<T> extends BaseValue<T> implements Serializable {
	private static final long serialVersionUID = 4271115516541292585L;
	private final Property<T> property;
	private final Type<T> type;

	PropertyValue(ObjectProperty<T> property, Type<T> type) {
		this.property = property;
		this.type = type;
		property.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 6450752229691056944L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				notifyObservers();
			}
		});
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
