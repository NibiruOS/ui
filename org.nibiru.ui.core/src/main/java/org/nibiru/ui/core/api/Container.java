package org.nibiru.ui.core.api;

public interface Container extends Widget, IsParent {
	void add(Widget child);

	void remove(Widget child);

	void clear();
	
	Iterable<Widget> getChildren();
}
