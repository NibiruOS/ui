
package org.nibiru.ui.core.impl;

import com.google.common.collect.Iterables;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Style;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseLayoutPanel extends BaseParentWidget implements Container {
    protected final AbsolutePanel panel;

    BaseLayoutPanel(AbsolutePanel panel,
                    Viewport viewport,
                    Looper looper) {
        super(viewport, looper);
        this.panel = checkNotNull(panel);
        panel.setParent(this);
    }

    @Override
    public Object asNative() {
        return panel.asNative();
    }

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        panel.add(child);
        child.setParent(this);
        scheduleLayout();
    }

    @Override
    public void remove(Widget child) {
        checkNotNull(child);
        panel.remove(child);
        child.setParent(null);
        scheduleLayout();
    }

    @Override
    public Iterable<Widget> getChildren() {
        return panel.getChildren();
    }

    public Iterable<Widget> getVisibleChildren() {
        return Iterables.filter(panel.getChildren(), (w) -> w.getVisible().get());
    }

    @Override
    public void clear() {
        panel.clear();
        scheduleLayout();
    }

    @Override
    public void onLayout() {
        panel.setNativeSize(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    public void setStyle(Style style) {
        super.setStyle(style);
        panel.setStyle(style);
    }

    @Override
    public void applyStyle() {
        panel.applyStyle();
    }

    @Override
    public Value<Boolean> getVisible() {
        return panel.getVisible();
    }

    protected int computeChildX(Widget child, int containerWidth) {
        switch (child.getStyle().getHorizontalAlignment()) {
            case START:
                return child.getStyle().getMarginLeft();
            case CENTER:
                return (containerWidth - child.getMeasuredWidth()) / 2;
            case END:
                return containerWidth - child.getMeasuredWidth() - child.getStyle().getMarginRight();
            default:
                throw new IllegalStateException("Invalid horizontal alignment: "
                        + child.getStyle().getHorizontalAlignment());
        }
    }

    protected int computeChildY(Widget child, int containerHeight) {
        switch (child.getStyle().getVerticalAlignment()) {
            case START:
                return child.getStyle().getMarginTop();
            case CENTER:
                return (containerHeight - child.getMeasuredHeight()) / 2;
            case END:
                return containerHeight - child.getMeasuredHeight() - child.getStyle().getMarginTop();
            default:
                throw new IllegalStateException("Invalid vertic alignment: "
                        + child.getStyle().getHorizontalAlignment());
        }
    }
}