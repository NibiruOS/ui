package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;
import com.vaadin.data.Property.Viewer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Component;

abstract class VaadinValueWidget<W extends Component & Viewer, T> extends VaadinWidget<W>implements ValueWidget<T> {
	private final Value<T> value;

	VaadinValueWidget(W component, Type<T> type, T proplValue) {
		super(component);
		@SuppressWarnings("unchecked")
		ObjectProperty<T> property = (ObjectProperty<T>) component.getPropertyDataSource();
		if (property == null) {
			property = new ObjectProperty<T>(proplValue, type.cast());
			component.setPropertyDataSource(property);
		}
		value = new PropertyValue<>(property, type);
	}

	@Override
	public Value<T> getValue() {
		return value;
	}
}
