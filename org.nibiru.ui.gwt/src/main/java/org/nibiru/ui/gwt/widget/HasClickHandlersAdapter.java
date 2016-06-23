package org.nibiru.ui.gwt.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;

class HasClickHandlersAdapter implements HasClickHandler {
	private final HasClickHandlers hasClickHandlers;
	private Registration clickHandlerRegistration;

	HasClickHandlersAdapter(HasClickHandlers hasClickHandlers) {
		this.hasClickHandlers = hasClickHandlers;
	}

	@Override
	public Registration setClickHandler(final ClickHandler clickHandler) {
		if (clickHandlerRegistration != null) {
			clickHandlerRegistration.remove();
		}

		clickHandlerRegistration = new HandlerRegistrationAdapter(
				hasClickHandlers.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						clickHandler.onClick();
					}
				}));

		return clickHandlerRegistration;
	}
}
