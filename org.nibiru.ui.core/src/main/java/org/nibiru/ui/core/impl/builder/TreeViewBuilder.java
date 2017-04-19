package org.nibiru.ui.core.impl.builder;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.impl.SimpleTreeViewItem;

import java.util.Collection;

import javax.inject.Inject;

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

	public TreeViewBuilder add(Widget widget) {
		SimpleTreeViewItem item = new SimpleTreeViewItem();
		item.setWidget(widget);
		items.add(item);
		return this;
	}

	@Override
	public TreeView build() {
		object.getValue().set(items);
		return super.build();
	}
}
