package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Checkbox;

public class CheckboxBuilder extends BaseValueBuilder<Checkbox, Boolean, CheckboxBuilder> {
	@Inject
	public CheckboxBuilder(Checkbox checkbox) {
		super(checkbox);
	}

	public CheckboxBuilder label(String text) {
		object.getTextLabel().set(text);
		return this;
	}
}
