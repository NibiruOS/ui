package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.TextBox;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class TextBoxBuilder extends BaseValueBuilder<TextBox, String, TextBoxBuilder> {
	@Inject
	public TextBoxBuilder(TextBox textBox) {
		super(textBox);
	}

	public TextBox build(@Nullable String text) {
		return value(text).build();
	}
}