package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.RadioButtonGroup;

public class RadioButtonGroupBuilder<T> extends BaseValueBuilder<RadioButtonGroup<T>, T, RadioButtonGroupBuilder<T>> {
	@Inject
	private static RadioButtonGroupBuilderFactory radioButtonGroupBuilderFactory;
	
	public static <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass) {
		return radioButtonGroupBuilderFactory.create(valueClass);
	}

	public RadioButtonGroupBuilder(RadioButtonGroup<T> control) {
		super(control);
	}

	public RadioButtonGroupBuilder<T> items(Iterable<T> items) {
		object.getItems().set(items);
		return getThis();
	}

}
