package org.nibiru.ui.dotnet.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;

import javax.inject.Inject;

import cli.System.Windows.Controls.Label;

public class DotNetTreeView extends DotNetValueWidget<Label, Iterable<Item>> implements TreeView {
    @Inject
    public DotNetTreeView() {
        super(new Label());
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

    @Override
    protected int getNativeHeight() {
        // TODO Fix value - add size computation
        return 480;
    }

    @Override
    protected int getNativeWidth() {
        // TODO Fix value - add size computation
        return 320;
    }
}
