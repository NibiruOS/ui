package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.Style;

public class LabelBuilder extends BaseValueBuilder<Label, String> {
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}

	public LabelBuilder text(String text) {
		object.getValue().set(text);
		return this;
	}

	public LabelBuilder style(Style style) {
		object.setStyle(style);
		return this;
	}
}
