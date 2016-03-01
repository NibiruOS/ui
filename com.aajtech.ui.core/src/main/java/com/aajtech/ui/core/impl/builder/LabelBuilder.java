package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Label;

public class LabelBuilder extends BaseValueBuilder<Label, String, LabelBuilder> {
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}
}
