package org.nibiru.ui.core.impl;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;

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
