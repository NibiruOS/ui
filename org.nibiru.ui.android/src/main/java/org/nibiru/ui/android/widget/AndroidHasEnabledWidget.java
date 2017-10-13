package org.nibiru.ui.android.widget;

import android.view.View;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasEnabled;

abstract class AndroidHasEnabledWidget<W extends View, V>
        extends AndroidValueWidget<W, V>
        implements HasEnabled {

    private final Value<Boolean> enabled = BaseValue.of(true);

    AndroidHasEnabledWidget(W control) {
        super(control);
        enabled.addObserver(() -> control.setEnabled(enabled.get()));
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
