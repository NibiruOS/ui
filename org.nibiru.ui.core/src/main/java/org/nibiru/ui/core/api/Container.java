package org.nibiru.ui.core.api;

public interface Container extends Widget {
	void add(Widget widget);

	void clear();
}
