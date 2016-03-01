package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Color;
import com.aajtech.ui.core.api.TextStyle;

public class TextStyleBuilder extends BaseStyleBuilder<TextStyle, TextStyleBuilder> {
	@Inject
	public TextStyleBuilder(TextStyle style) {
		super(style);
	}

	public TextStyleBuilder textColor(Color textColor) {
		object.setTextColor(textColor);
		return this;
	}
}
