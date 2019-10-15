package org.nibiru.ui.swing.widget;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class SwingContainer extends SwingWidget<JPanel> implements Container {
    private final List<Widget> children = Lists.newArrayList();

    SwingContainer() {
        super(new JPanel());
        control.addComponentListener(new ComponentAdapter() {
            private Dimension lastSize = control.getSize();
            private long lastLayoutTimestamp = System.currentTimeMillis();

            @Override
            public void componentResized(ComponentEvent componentEvent) {
                long now = System.currentTimeMillis();
                if (!control.getSize().equals(lastSize) && now - lastLayoutTimestamp > 10) {
                    lastSize = control.getSize();
                    lastLayoutTimestamp = now;
                    scheduleLayout();
                }
            }
        });
    }

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        control.add((JComponent) child.asNative());
        children.add(child);
        child.setParent(this);
        requestLayout();
    }

    @Override
    public void remove(Widget child) {
        checkNotNull(child);
        control.remove((JComponent) child.asNative());
        children.remove(child);
        child.setParent(null);
        requestLayout();
    }

    @Override
    public Iterable<Widget> getChildren() {
        return children;
    }

    Iterable<Widget> getVisibleChildren() {
        return Iterables.filter(children, (w) -> w.getVisible().get());
    }

    @Override
    public void clear() {
        control.removeAll();
        for (Widget child : children) {
            child.setParent(null);
        }
        children.clear();
    }
}
