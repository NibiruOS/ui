
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

public abstract class BaseLayoutPanel extends BaseWidget implements Container {
    protected final AbsolutePanel panel;
    private final Viewport viewport;
    private final Looper looper;
    private boolean isLayoutScheduled;
    private boolean isLayoutDirty;

    BaseLayoutPanel(AbsolutePanel panel, Viewport viewport, Looper looper) {
        this.panel = checkNotNull(panel);
        this.viewport = checkNotNull(viewport);
        this.looper = checkNotNull(looper);
    }

    @Override
    public Object asNative() {
        return panel.asNative();
    }

    @Override
    public void add(Widget child) {
        panel.add(child);
        child.setParent(this);
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

    /**
     * Method to request the measure and layout of the panel and all its children.
     * For the measure phase the MeasureSpec with the restrictions to its children should be passed.
     */
    @Override
    public void requestLayout() {
        requestLayout(viewport);
    }

    @Override
    public void layout() {
        super.layout();
        isLayoutDirty = false;
    }

    @Override
    public void scheduleLayout() {
        isLayoutDirty = true;
        if (getParent() != null) {
            getParent().scheduleLayout();
            isLayoutScheduled = false;
        } else if (!isLayoutScheduled) {
            looper.post(() -> {
                isLayoutScheduled = false;
                if (getParent() != null) {
                    getParent().scheduleLayout();
                } else {
                    if (isLayoutDirty) {
                        requestLayout();
                    }
                }
            });
        }
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
}