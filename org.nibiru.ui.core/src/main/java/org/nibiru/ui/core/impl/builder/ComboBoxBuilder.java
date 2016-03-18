package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ComboBox;

public class ComboBoxBuilder<T> extends BaseValueBuilder<ComboBox<T>, T, ComboBoxBuilder<T>> {
	public ComboBoxBuilder(ComboBox<T> control) {
		super(control);
	}

	public ComboBoxBuilder<T> items(Iterable<T> items) {
		object.getItems().set(items);
		return getThis();
	}

}
