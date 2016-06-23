package org.nibiru.ui.core.api;

public interface Widget {
	String STYLE_NAME_PREFIX = "nibiru_";

	Object asNative();

	void setStyleName(Enum<?> styleName);
}
