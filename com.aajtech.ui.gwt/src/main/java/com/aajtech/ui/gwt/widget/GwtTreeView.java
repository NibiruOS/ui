package com.aajtech.ui.gwt.widget;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.TreeView.Item;
import com.google.gwt.user.client.ui.HasTreeItems;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class GwtTreeView extends GwtValueWidget<Tree, Iterable<Item>>implements TreeView {
	public GwtTreeView() {
		this(new Tree());
	}

	public GwtTreeView(Tree control) {
		super(control);
	}

	@Override
	Value<Iterable<Item>> buildValue() {
		return new BaseValue<Iterable<Item>>() {
			private Iterable<Item> items;

			@Override
			public Iterable<Item> get() {
				return items;
			}

			@Override
			protected void setValue(@Nullable Iterable<Item> value) {
				items = value;
				control.clear();
				if (items != null) {
					for (Item item : items) {
						addItem(control, item);
					}
				}
			}

			@Override
			public Type<Iterable<Item>> getType() {
				return JavaType.ofIterable(Item.class);
			}

			private void addItem(HasTreeItems parent, Item item) {
				TreeItem treeItem = new TreeItem((Widget) item.getWidget().asNative());
				parent.addItem(treeItem);
				for (Item child : item.getChildren()) {
					addItem(treeItem, child);
				}
			}
		};
	}
}
