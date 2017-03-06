package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;
import org.teavm.jso.dom.html.HTMLElement;

abstract class TeaVmValueWidget<W extends HTMLElement, V> extends TeaVmWidget<W> implements ValueWidget<V> {
    private Value<V> value;

    TeaVmValueWidget(W control) {
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