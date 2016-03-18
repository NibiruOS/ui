package com.aajtech.ui.core.api;

public interface Container extends Widget {
	void add(Widget widget);

	void clear();
	
	Iterable<Widget> getChildren();

	void requestLayout();
}
