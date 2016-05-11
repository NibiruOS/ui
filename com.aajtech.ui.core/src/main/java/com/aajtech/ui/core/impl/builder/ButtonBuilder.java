package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;

public class ButtonBuilder extends BaseClickableValueBuilder<Button, String, ButtonBuilder> {
	@Inject
	private static Provider<ButtonBuilder> buttonBuilderProvider;

	public static ButtonBuilder button() {
		return buttonBuilderProvider.get();
	}

	public static Button button(@Nullable String text, ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		return button().value(text).onClick(clickHandler).build();
	}

	@Inject
	public ButtonBuilder(Button button) {
		super(button);
	}
}
