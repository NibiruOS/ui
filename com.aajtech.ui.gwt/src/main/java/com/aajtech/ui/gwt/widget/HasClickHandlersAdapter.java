package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HasClickHandlersAdapter implements HasClickHandler {
	private final HasClickHandlers hasClickHandlers;
	private Registration clickHandlerRegistration;

	public HasClickHandlersAdapter(HasClickHandlers hasClickHandlers) {
		this.hasClickHandlers = checkNotNull(hasClickHandlers);
	}

	@Override
	public Registration setClickHandler(final ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickHandlerRegistration != null) {
			clickHandlerRegistration.remove();
		}

		clickHandlerRegistration = new HandlerRegistrationAdapter(
				hasClickHandlers
						.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								clickHandler.onClick();

							}
						}));

		return clickHandlerRegistration;
	}
}
