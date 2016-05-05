package com.aajtech.ui.core.api;

import com.aajtech.ui.core.api.TreeView.Item;

public interface TreeView extends ValueWidget<Iterable<Item>> {
	public interface Item {
		Widget getWidget();

		Iterable<Item> getChildren();
	}
}
