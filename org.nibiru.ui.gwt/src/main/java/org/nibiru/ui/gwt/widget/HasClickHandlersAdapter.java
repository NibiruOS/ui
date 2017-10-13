package org.nibiru.ui.gwt.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;

class HasClickHandlersAdapter implements HasClickHandler {
    private final HasClickHandlers hasClickHandlers;
    private final Value<Boolean> enabled;
    private Registration clickHandlerRegistration;

    HasClickHandlersAdapter(HasClickHandlers hasClickHandlers,
                            Value<Boolean> enabled) {
        this.hasClickHandlers = hasClickHandlers;
        this.enabled = enabled;
    }

    @Override
    public Registration setClickHandler(final ClickHandler clickHandler) {
        if (clickHandlerRegistration != null) {
            clickHandlerRegistration.remove();
        }

        clickHandlerRegistration = new HandlerRegistrationAdapter(
                hasClickHandlers.addClickHandler(event -> {
                    if (enabled.get()) {
                        clickHandler.onClick();
                    }
                }));

        return clickHandlerRegistration;
    }
}
