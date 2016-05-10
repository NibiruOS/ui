package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Checkbox;

public class CheckboxBuilder extends BaseValueBuilder<Checkbox, Boolean, CheckboxBuilder> {
	@Inject
	private static Provider<CheckboxBuilder> checkboxBuilderProvider;

	public static CheckboxBuilder checkbox() {
		return checkboxBuilderProvider.get();
	}

	@Inject
	public CheckboxBuilder(Checkbox checkbox) {
		super(checkbox);
	}

	public CheckboxBuilder label(String text) {
		object.getTextLabel().set(text);
		return this;
	}
}
