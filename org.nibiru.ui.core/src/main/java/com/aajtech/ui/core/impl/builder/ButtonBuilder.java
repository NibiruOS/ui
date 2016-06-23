package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;
import javax.inject.Inject;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;

public class ButtonBuilder extends BaseClickableValueBuilder<Button, String, ButtonBuilder> {
	@Inject
	public ButtonBuilder(Button button) {
		super(button);
	}
	
	public Button build(@Nullable String text, ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		return value(text).onClick(clickHandler).build();
	}
}
