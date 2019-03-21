package org.nibiru.ui.core.impl.builder;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.impl.SimpleTreeViewItem;

import java.util.Collection;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TreeViewBuilder
        extends BaseBuilder<TreeView>
        implements ValueWidgetBuilder<TreeView, Iterable<Item>, TreeViewBuilder> {
    private final Collection<Item> items = Lists.newArrayList();

    @Inject
    public TreeViewBuilder(TreeView control) {
        super(control);
    }

    public TreeViewBuilder add(Item item) {
        checkNotNull(item);
        items.add(item);
        return this;
    }

    public TreeViewBuilder add(Widget widget) {
        checkNotNull(widget);
        SimpleTreeViewItem item = new SimpleTreeViewItem();
        item.setWidget(widget);
        items.add(item);
        return this;
    }

    public TreeViewBuilder add(Builder<? extends Widget> widget) {
        checkNotNull(widget);
        return add(widget.build());
    }

    @Override
    public TreeView build() {
        object.getValue().set(items);
        return super.build();
    }
}
