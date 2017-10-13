package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface RadioButtonGroup<V>
        extends ValueWidget<V>, HasEnabled {
    Value<Iterable<V>> getItems();
}
