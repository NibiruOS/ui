package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Registration;

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
