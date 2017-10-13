package org.nibiru.ui.gwt.widget;


import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasEnabled;

abstract class GwtHasEnabledWidget<W extends Widget & com.google.gwt.user.client.ui.HasEnabled, V>
        extends GwtValueWidget<W, V>
        implements HasEnabled {

    private final Value<Boolean> enabled = BaseValue.of(true);

    GwtHasEnabledWidget(W control) {
        super(control);
        enabled.addObserver(() -> this.control.setEnabled(enabled.get()));
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
