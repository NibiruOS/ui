package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class HandlerRegistrationAdapter implements Registration {
	private final HandlerRegistration handlerRegistration;

	public HandlerRegistrationAdapter(HandlerRegistration handlerRegistration) {
		this.handlerRegistration = checkNotNull(handlerRegistration);
	}

	@Override
	public void remove() {
		handlerRegistration.removeHandler();
	}
}
