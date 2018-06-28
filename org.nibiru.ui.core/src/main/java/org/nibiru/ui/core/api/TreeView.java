package org.nibiru.ui.core.api;

import org.nibiru.ui.core.api.TreeView.Item;

public interface TreeView extends ValueWidget<Iterable<Item>> {
	interface Item {
		Widget getWidget();

		Iterable<Item> getChildren();
	}
}
