package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.TextBox;

public class TextBoxBuilder extends BaseValueBuilder<TextBox, String> {
	@Inject
	public TextBoxBuilder(TextBox textBox) {
		super(textBox);
	}

	public TextBoxBuilder text(String text) {
		widget.getValue().set(text);
		return this;
	}
}