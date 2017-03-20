package org.nibiru.ui.dotnet.widget;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import cli.System.Windows.Controls.Panel;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class DotNetContainer<T extends Panel> extends DotNetWidget<T> implements Container {
    private final List<Widget> children = Lists.newArrayList();

    DotNetContainer(T control) {
        super(control);
    }

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        control.AddChild(child.asNative());
        children.add(child);
        child.setParent(this);
    }

    @Override
    public Iterable<Widget> getChildren() {
        return children;
    }

    @Override
    public void clear() {
        while (control.get_Children().get_Count() > 0) {
            control.get_Children().RemoveAt(0);
        }
        for (Widget child : children) {
            child.setParent(null);
        }
        children.clear();
    }
}
