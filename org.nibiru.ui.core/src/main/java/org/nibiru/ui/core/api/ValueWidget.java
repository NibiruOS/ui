package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface ValueWidget<T> extends Widget {
	Value<T> getValue();
}
