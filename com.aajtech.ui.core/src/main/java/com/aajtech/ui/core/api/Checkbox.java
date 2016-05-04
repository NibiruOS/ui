package com.aajtech.ui.core.api;

import com.aajtech.model.core.api.Value;

public interface Checkbox extends ValueWidget<Boolean> {
	Value<String> getTextLabel();
}
