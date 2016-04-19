package com.aajtech.ui.core.api;

public interface Widget {
	String STYLE_NAME_PREFIX = "nibiru-";

	Object asNative();

	void addStyleName(Enum<?> styleName);
}
