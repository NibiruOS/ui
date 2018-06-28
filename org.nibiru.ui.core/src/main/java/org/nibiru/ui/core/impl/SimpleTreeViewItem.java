package org.nibiru.ui.core.impl;

import com.google.common.collect.ImmutableList;

import org.nibiru.ui.core.api.TreeView.Item;
import org.nibiru.ui.core.api.Widget;

public class SimpleTreeViewItem implements Item {
	private Widget widget;
	private Iterable<Item> children;

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

	public void setChildren(Iterable<Item> children) {
		this.children = children;
	}

	@Override
	public Widget getWidget() {
		return widget;
	}

	@Override
	public Iterable<Item> getChildren() {
		return children != null ? children : ImmutableList.of();
	}
}
