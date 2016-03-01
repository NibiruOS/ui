package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.TextBox;

public class TextBoxBuilder extends BaseValueBuilder<TextBox, String, TextBoxBuilder> {
	@Inject
	public TextBoxBuilder(TextBox textBox) {
		super(textBox);
	}
}