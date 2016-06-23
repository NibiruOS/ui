package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface Checkbox extends ValueWidget<Boolean> {
	Value<String> getTextLabel();
}
