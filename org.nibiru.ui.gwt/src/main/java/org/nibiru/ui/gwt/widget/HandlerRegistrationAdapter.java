package org.nibiru.ui.gwt.widget;

import com.google.web.bindery.event.shared.HandlerRegistration;

import org.nibiru.model.core.api.Registration;

import static com.google.common.base.Preconditions.checkNotNull;

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
