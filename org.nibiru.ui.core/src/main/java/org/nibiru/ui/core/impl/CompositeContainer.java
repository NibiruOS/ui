package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class CompositeContainer<T extends Container>
        extends CompositeWidget<T>
        implements Container {

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        widget.add(child);
    }

    @Override
    public void clear() {
        widget.clear();
    }

    @Override
    public Iterable<Widget> getChildren() {
        return widget.getChildren();
    }

    @Override
    public void requestLayout() {
        widget.requestLayout();
    }

    @Override
    public void scheduleLayout() {
        widget.scheduleLayout();
    }
}
