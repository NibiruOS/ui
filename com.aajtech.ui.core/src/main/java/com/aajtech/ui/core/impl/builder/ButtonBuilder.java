package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;

public class ButtonBuilder extends BaseValueBuilder<Button, String, ButtonBuilder> {
	@Inject
	public ButtonBuilder(Button button) {
		super(button);
	}

	public ButtonBuilder onClick(ClickHandler clickHandler) {
		object.setClickHandler(clickHandler);
		return this;
	}
}
