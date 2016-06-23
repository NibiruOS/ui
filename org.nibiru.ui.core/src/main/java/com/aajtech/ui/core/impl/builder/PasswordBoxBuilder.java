package com.aajtech.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;

import com.aajtech.ui.core.api.PasswordBox;

public class PasswordBoxBuilder extends BaseValueBuilder<PasswordBox, String, PasswordBoxBuilder> {
	@Inject
	public PasswordBoxBuilder(PasswordBox passwordBox) {
		super(passwordBox);
	}

	public PasswordBox build(@Nullable String text) {
		return value(text).build();
	}
}