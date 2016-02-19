package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Color;
import com.aajtech.ui.core.api.Style;

public class StyleBuilder extends BaseBuilder<Style> {
	@Inject
	public StyleBuilder(Style widget) {
		super(widget);
	}

	public StyleBuilder backgroundColor(Color backgroundColor) {
		object.setBackgroundColor(backgroundColor);
		return this;
	}

	public StyleBuilder marginTop(int marginTop) {
		object.setMarginTop(marginTop);
		return this;
	}

	public StyleBuilder marginRight(int marginRight) {
		object.setMarginRight(marginRight);
		return this;
	}

	public StyleBuilder marginLeft(int marginLeft) {
		object.setMarginLeft(marginLeft);
		return this;
	}

	public StyleBuilder marginBottom(int marginBottom) {
		object.setMarginBottom(marginBottom);
		return this;
	}
}
