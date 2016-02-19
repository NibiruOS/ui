package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.PasswordBox;

public class PasswordBoxBuilder extends BaseValueBuilder<PasswordBox, String> {
	@Inject
	public PasswordBoxBuilder(PasswordBox passwordBox) {
		super(passwordBox);
	}

	public PasswordBoxBuilder text(String text) {
		object.getValue().set(text);
		return this;
	}
}