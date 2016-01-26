package com.aajtech.ui.vaadin.widget;

import java.io.Serializable;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.ObjectProperty;

class PropertyValue<T> extends BaseValue<T> implements Serializable {
	private final Property<T> property;
	private final Type<T> type;

	PropertyValue(ObjectProperty<T> property, Type<T> type) {
		this.property = property;
		this.type = type;
		property.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				notifyObservers();
			}
		});
	}

	@Override
	@Nullable
	public T get() {
		return property.getValue();
	}

	@Override
	protected void setValue(@Nullable T value) {
		property.setValue(value);
	}

	@Override
	public Type<T> getType() {
		return type;
	}
}
