package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Checkbox;

public class CheckboxBuilder extends BaseValueBuilder<Checkbox, Boolean, CheckboxBuilder>{

	@Inject
	public CheckboxBuilder(Checkbox checkbox) {
		super(checkbox);
	}
	
	public CheckboxBuilder setLabel(String text) {
		object.getTextLabel().set(text);
		return this;
	}
}
