package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.HasEnabled;

import javax.swing.JComponent;

abstract class SwingHasEnabledWidget<T extends JComponent, V>
        extends SwingValueWidget<T, V>
        implements HasEnabled {
    private final Value<Boolean> enabled = BaseValue.of(true);

    SwingHasEnabledWidget(T control) {
        super(control);
        enabled.addObserver(() -> this.control.setEnabled(enabled.get()));
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
