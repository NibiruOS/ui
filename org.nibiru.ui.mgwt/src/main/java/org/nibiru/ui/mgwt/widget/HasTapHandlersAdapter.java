package org.nibiru.ui.mgwt.widget;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.gwt.widget.HandlerRegistrationAdapter;

import static com.google.common.base.Preconditions.checkNotNull;

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
