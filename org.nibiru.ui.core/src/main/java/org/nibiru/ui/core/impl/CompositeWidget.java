package org.nibiru.ui.core.impl;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Style;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public abstract class CompositeWidget<T extends Widget> implements Widget {
    T widget;
    private final Value<Boolean> visible = BaseValue.of(true);
    private Object tag;

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
    public int getFullMeasuredHeight() {
        return widget.getFullMeasuredHeight();
    }

    @Override
    public int getFullMeasuredWidth() {
        return widget.getFullMeasuredWidth();
    }

    @Override
    public void layout() {
        widget.layout();
    }

    @Override
    public void requestLayout() {
        widget.requestLayout();
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

    @Override
    public Value<Boolean> getVisible() {
        return visible;
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public void setTag(@Nullable Object tag) {
        this.tag = tag;
    }
}
