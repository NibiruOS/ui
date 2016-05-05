package com.aajtech.ui.core.impl.builder;

import java.util.Collection;

import javax.inject.Inject;

import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.TreeView.Item;
import com.google.common.collect.Lists;

public class TreeViewBuilder extends BaseValueBuilder<TreeView, Iterable<Item>, TreeViewBuilder> {
	private final Collection<Item> items = Lists.newArrayList();

	@Inject
	public TreeViewBuilder(TreeView control) {
		super(control);
	}

	public TreeViewBuilder add(Item item) {
		items.add(item);
		return this;
	}

	@Override
	public TreeView build() {
		object.getValue().set(items);
		return super.build();
	}
}
