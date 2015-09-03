package com.aajtech.ui.vaadin;

import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.java.JavaType;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Label;

public class VaadinLabel implements com.aajtech.ui.core.api.Label {
	private final Property<String> property = new ObjectProperty<>(null, String.class);
	private final Label label = new Label(property);
	private final Value<String> value = new PropertyValue<>(property, JavaType.STRING);

	@Override
	public Value<String> getValue() {
		return value;
	}

	@Override
	public Label asNative() {
		return label;
	}
}
