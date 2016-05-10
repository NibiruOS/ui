package com.aajtech.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.PasswordBox;

public class PasswordBoxBuilder extends BaseValueBuilder<PasswordBox, String, PasswordBoxBuilder> {
	@Inject
	private static Provider<PasswordBoxBuilder> passwordBoxBuilderProvider;

	public static PasswordBoxBuilder passwordBox() {
		return passwordBoxBuilderProvider.get();
	}

	public static PasswordBox passwordBox(@Nullable String text) {
		return passwordBox().value(text).build();
	}

	@Inject
	public PasswordBoxBuilder(PasswordBox passwordBox) {
		super(passwordBox);
	}
}