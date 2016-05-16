package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.RadioButtonGroup;

public class RadioButtonGroupBuilder<T> extends BaseValueBuilder<RadioButtonGroup<T>, T, RadioButtonGroupBuilder<T>> {
	public RadioButtonGroupBuilder(RadioButtonGroup<T> control) {
		super(control);
	}

	public RadioButtonGroupBuilder<T> items(Iterable<T> items) {
		object.getItems().set(items);
		return getThis();
	}

}
