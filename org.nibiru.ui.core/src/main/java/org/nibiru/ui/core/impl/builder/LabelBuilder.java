package org.nibiru.ui.core.impl.builder;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.nibiru.ui.core.api.Label;

public class LabelBuilder extends BaseClickableValueBuilder<Label, String, LabelBuilder> {
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}

	public Label build(@Nullable String text) {
		return value(text).build();
	}
}