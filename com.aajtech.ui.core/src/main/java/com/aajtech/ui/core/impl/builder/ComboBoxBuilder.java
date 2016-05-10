package com.aajtech.ui.core.impl.builder;

import java.util.List;

import javax.inject.Inject;

import com.aajtech.ui.core.api.ComboBox;

public class ComboBoxBuilder<T> extends BaseValueBuilder<ComboBox<T>, T, ComboBoxBuilder<T>> {
	@Inject
	private static ComboBoxBuilderFactory comboBoxBuilderFactory;

	public static <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass) {
		return comboBoxBuilderFactory.create(valueClass);
	}

	public ComboBoxBuilder(ComboBox<T> control) {
		super(control);
	}

	public ComboBoxBuilder<T> items(List<T> items) {
		object.getItems().set(items);
		return getThis();
	}

}
