package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasEnabled;

abstract class GwtHasEnabledHasValueWidget<W extends Widget & com.google.gwt.user.client.ui.HasEnabled & HasValue<V>, V>
        extends GwtHasValueWidget<W, V>
        implements HasEnabled {

    private final Value<Boolean> enabled = BaseValue.of(true);

    GwtHasEnabledHasValueWidget(W control, Type<V> type) {
        super(control, type);
        enabled.addObserver(() -> this.control.setEnabled(enabled.get()));
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
