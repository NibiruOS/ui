package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface HasItems<V> {
    Value<Iterable<V>> getItems();
}
