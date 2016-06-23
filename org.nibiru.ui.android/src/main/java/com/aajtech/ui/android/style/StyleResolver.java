package com.aajtech.ui.android.style;

public interface StyleResolver {
	int NO_STYLE = 0;
	int resolveStyle(Enum<?> styleName);
}
