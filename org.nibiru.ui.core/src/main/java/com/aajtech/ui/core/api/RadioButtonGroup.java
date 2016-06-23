package com.aajtech.ui.core.api;

import com.aajtech.model.core.api.Value;

public interface RadioButtonGroup<V> extends ValueWidget<V> {
	Value<Iterable<V>> getItems();
}
