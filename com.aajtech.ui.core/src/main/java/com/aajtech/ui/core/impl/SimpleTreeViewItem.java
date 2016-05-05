package com.aajtech.ui.core.impl;

import com.aajtech.ui.core.api.TreeView.Item;
import com.aajtech.ui.core.api.Widget;
import com.google.common.collect.ImmutableList;

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
