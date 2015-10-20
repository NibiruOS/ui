package com.aajtech.ui.mgwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;
import com.aajtech.ui.gwt.widget.HandlerRegistrationAdapter;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class HasTapHandlersAdapter implements HasClickHandler {
	private final HasTapHandlers hasClickHandlers;
	private Registration tapHandlerRegistration;

	public HasTapHandlersAdapter(HasTapHandlers hasTapHandlers) {
		this.hasClickHandlers = checkNotNull(hasTapHandlers);
	}

	@Override
	public Registration setClickHandler(final ClickHandler clickHandler) {
		if (tapHandlerRegistration != null) {
			tapHandlerRegistration.remove();
		}

		tapHandlerRegistration = new HandlerRegistrationAdapter(
				hasClickHandlers.addTapHandler(new TapHandler() {
					@Override
					public void onTap(TapEvent event) {
						clickHandler.onClick();
					}
				}));

		return tapHandlerRegistration;
	}
}
