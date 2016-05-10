package com.aajtech.ui.core.impl.builder;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.TreeView.Item;
import com.aajtech.ui.core.api.Widget;
import com.aajtech.ui.core.impl.SimpleTreeViewItem;
import com.google.common.collect.Lists;

public class TreeViewItemBuilder extends BaseBuilder<SimpleTreeViewItem> {
	@Inject
	private static Provider<TreeViewItemBuilder> treeViewItemBuilderProvider;

	public static TreeViewItemBuilder treeViewItem(Widget widget) {
		return treeViewItemBuilderProvider.get().widget(widget);
	}

	private final Collection<Item> items = Lists.newArrayList();

	public TreeViewItemBuilder() {
		super(new SimpleTreeViewItem());
	}

	public TreeViewItemBuilder widget(Widget widget) {
		object.setWidget(widget);
		return this;
	}

	public TreeViewItemBuilder add(Item item) {
		items.add(item);
		return this;
	}

	public TreeViewItemBuilder add(Widget widget) {
		SimpleTreeViewItem item = new SimpleTreeViewItem();
		item.setWidget(widget);
		items.add(item);
		return this;
	}

	@Override
	public SimpleTreeViewItem build() {
		object.setChildren(items);
		return super.build();
	}
}
