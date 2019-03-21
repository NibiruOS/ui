package org.nibiru.ui.core.impl.builder;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.TreeView.Item;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.impl.SimpleTreeViewItem;

import java.util.Collection;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TreeViewItemBuilder extends BaseBuilder<SimpleTreeViewItem> {
    private final Collection<Item> items = Lists.newArrayList();

    @Inject
    public TreeViewItemBuilder() {
        super(new SimpleTreeViewItem());
    }

    public TreeViewItemBuilder widget(Widget widget) {
        checkNotNull(widget);
        object.setWidget(widget);
        return this;
    }

    public TreeViewItemBuilder widget(Builder<? extends Widget> widget) {
        checkNotNull(widget);
        return widget(widget.build());
    }

    public TreeViewItemBuilder add(Item item) {
        checkNotNull(item);
        items.add(item);
        return this;
    }

    public TreeViewItemBuilder add(Widget widget) {
        checkNotNull(widget);
        SimpleTreeViewItem item = new SimpleTreeViewItem();
        item.setWidget(widget);
        items.add(item);
        return this;
    }

    public TreeViewItemBuilder add(Builder<? extends Widget> widget) {
        checkNotNull(widget);
        return add(widget.build());
    }

    @Override
    public SimpleTreeViewItem build() {
        object.setChildren(items);
        return super.build();
    }

    public SimpleTreeViewItem build(Widget widget) {
        checkNotNull(widget);
        return widget(widget).build();
    }
}
