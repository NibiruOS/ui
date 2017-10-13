package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface ComboBox <V>
		extends ValueWidget<V>, HasEnabled {
	Value<Iterable<V>> getItems();
}

