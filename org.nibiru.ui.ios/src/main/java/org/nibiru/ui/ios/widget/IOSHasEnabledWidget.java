package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasEnabled;

import apple.uikit.UIView;

abstract class IOSHasEnabledWidget<T extends UIView, V>
        extends IOSValueWidget<T, V>
        implements HasEnabled {
    private final Value<Boolean> enabled = BaseValue.of(true);

    IOSHasEnabledWidget(T control) {
        super(control);
        enabled.addObserver(() -> this.control.setUserInteractionEnabled(enabled.get()));
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
