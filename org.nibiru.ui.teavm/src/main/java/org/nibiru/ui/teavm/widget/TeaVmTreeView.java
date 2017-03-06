package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;
import org.teavm.jso.dom.html.HTMLElement;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class TeaVmTreeView extends TeaVmValueWidget<HTMLElement, Iterable<Item>> implements TreeView {
	@Inject
	public TeaVmTreeView() {
		this(createElement("div"));
	}

	public TeaVmTreeView(HTMLElement control) {
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
						//addItem(control, item);
					}
				}
			}

			@Override
			public Type<Iterable<Item>> getType() {
				return JavaType.ofIterable(Item.class);
			}

//			private void addItem(HasTreeItems parent, Item item) {
//				TreeItem treeItem = new TreeItem((Widget) item.getWidget().asNative());
//				parent.addItem(treeItem);
//				for (Item child : item.getChildren()) {
//					addItem(treeItem, child);
//				}
//			}
		};
	}
}
