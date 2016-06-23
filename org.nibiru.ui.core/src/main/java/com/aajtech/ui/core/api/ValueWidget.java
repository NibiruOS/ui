package com.aajtech.ui.core.api;

import com.aajtech.model.core.api.Value;

public interface ValueWidget<T> extends Widget {
	Value<T> getValue();
}
