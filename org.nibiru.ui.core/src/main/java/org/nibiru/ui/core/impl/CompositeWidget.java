package org.nibiru.ui.core.impl;


import com.google.common.base.Preconditions;

import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Style;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public abstract class CompositeWidget<T extends Widget> implements Widget {
    T widget;

    protected void initWidget(T widget) {
        checkState(this.widget == null, "Widget already initialized");
        this.widget = checkNotNull(widget);
    }

    @Override
    public Object asNative() {
        return widget.asNative();
    }

    @Override
    public void measure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        widget.measure(widthSpec, heightSpec);
    }

    @Override
    public int getMeasuredHeight() {
        return widget.getMeasuredHeight();
    }

    @Override
    public int getMeasuredWidth() {
        return widget.getMeasuredWidth();
    }

    @Override
    public void layout() {
        widget.layout();
    }

    @Nullable
    @Override
    public IsParent getParent() {
        return widget.getParent();
    }

    @Override
    public void setParent(@Nullable IsParent parent) {
        widget.setParent(parent);
    }

    @Override
    public void setStyle(Style style) {
        checkNotNull(style);
        widget.setStyle(style);
    }

    @Override
    public Style getStyle() {
        return widget.getStyle();
    }

    @Override
    public void applyStyle() {
        widget.applyStyle();
    }
}
