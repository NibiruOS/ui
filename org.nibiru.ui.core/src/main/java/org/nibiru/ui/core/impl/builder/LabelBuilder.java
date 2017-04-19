package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Label;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class LabelBuilder extends BaseClickableValueBuilder<Label, String, LabelBuilder> {
	@Inject
	public LabelBuilder(Label label) {
		super(label);
	}

	public Label build(@Nullable String text) {
		return value(text).build();
	}
}
