package org.nibiru.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.nibiru.ui.core.api.TextBox;

public class TextBoxBuilder extends BaseValueBuilder<TextBox, String, TextBoxBuilder> {
	@Inject
	public TextBoxBuilder(TextBox textBox) {
		super(textBox);
	}

	public TextBox build(@Nullable String text) {
		return value(text).build();
	}
}