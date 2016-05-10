package com.aajtech.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.TextBox;

public class TextBoxBuilder extends BaseValueBuilder<TextBox, String, TextBoxBuilder> {
	@Inject
	private static Provider<TextBoxBuilder> textBoxBuilderProvider;

	public static TextBoxBuilder textBox() {
		return textBoxBuilderProvider.get();
	}

	public static TextBox textBox(@Nullable String text) {
		return textBox().value(text).build();
	}

	@Inject
	public TextBoxBuilder(TextBox textBox) {
		super(textBox);
	}
}