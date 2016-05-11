package com.aajtech.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Label;

public class LabelBuilder extends BaseClickableValueBuilder<Label, String, LabelBuilder> {
	@Inject
	private static Provider<LabelBuilder> labelBuilderProvider;
	
	public static LabelBuilder label() {
		return labelBuilderProvider.get();
	}

	public static Label label(@Nullable String text) {
		return label().value(text).build();
	}
	
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}
}
