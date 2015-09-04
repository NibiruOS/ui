package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Label;

public class LabelBuilder extends BaseValueBuilder<Label, String> {
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}

	public LabelBuilder text(String text) {
		widget.getValue().set(text);
		return this;
	}
}
