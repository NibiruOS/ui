package com.aajtech.ui.core.impl;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;

public class SimpleClickHandler implements HasClickHandler, ClickHandler {
	private ClickHandler wrappedClickHandler;

	@Override
	public void onClick() {
		if (wrappedClickHandler != null) {
			wrappedClickHandler.onClick();
		}
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		wrappedClickHandler = clickHandler;
		return new Registration() {
			@Override
			public void remove() {
				wrappedClickHandler = null;
			}
		};
	}
}
