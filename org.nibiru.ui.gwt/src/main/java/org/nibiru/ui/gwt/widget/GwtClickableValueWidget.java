package org.nibiru.ui.gwt.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.HasEnabled;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class GwtClickableValueWidget<W extends Widget & HasClickHandlers, V>
        extends GwtValueWidget<W, V>
        implements HasClickHandler, HasEnabled {

    final Value<Boolean> enabled = BaseValue.of(true);
    private HasClickHandlersAdapter hasClickHandlersAdapter;

    GwtClickableValueWidget(W control) {
        super(control);
        hasClickHandlersAdapter = new HasClickHandlersAdapter(control, enabled);
    }

    @Override
    public Registration setClickHandler(org.nibiru.ui.core.api.ClickHandler clickHandler) {
        checkNotNull(clickHandler);
        return hasClickHandlersAdapter.setClickHandler(clickHandler);
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
