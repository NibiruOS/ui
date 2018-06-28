package org.nibiru.ui.android.widget;

import android.view.View;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

abstract class AndroidValueWidget<W extends View, V>
        extends AndroidWidget<W>
        implements ValueWidget<V> {
    private Value<V> value;

    AndroidValueWidget(W control) {
        super(control);
    }

    @Override
    public Value<V> getValue() {
        if (value == null) {
            value = buildValue();
        }
        return value;
    }

    abstract Value<V> buildValue();
}
