package org.nibiru.ui.core.api;

public interface Container extends Widget, IsParent {
	void add(Widget widget);

	void clear();
	
	Iterable<Widget> getChildren();
}
