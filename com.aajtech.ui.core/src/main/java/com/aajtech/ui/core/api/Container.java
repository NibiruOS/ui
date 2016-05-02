package com.aajtech.ui.core.api;

/**
 * Interface for widgets containing multiple widgets.
 */
public interface Container extends Widget {
	void add(Widget widget);

	void clear();
}
