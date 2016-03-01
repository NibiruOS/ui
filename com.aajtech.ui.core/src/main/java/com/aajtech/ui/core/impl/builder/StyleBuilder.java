package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Style;

public class StyleBuilder extends BaseStyleBuilder<Style, StyleBuilder> {
	@Inject
	public StyleBuilder(Style style) {
		super(style);
	}
}
