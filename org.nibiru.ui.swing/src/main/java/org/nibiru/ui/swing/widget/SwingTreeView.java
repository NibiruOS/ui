package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;

import javax.inject.Inject;
import javax.swing.JPanel;


// TODO: Implement the SwingTreeView!
public class SwingTreeView extends SwingValueWidget<JPanel, Iterable<Item>> implements TreeView {
    @Inject
    public SwingTreeView() {
        super(new JPanel());
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
            protected void setValue(Iterable<Item> value) {
                items = value;

            }

            @Override
            public Type<Iterable<Item>> getType() {
                return JavaType.ofIterable(Item.class);
            }
        };
    }
}
