package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.HasContent;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseContentWidget<T, N> extends BaseWidget implements HasContent {
    protected final T control;
    private final Viewport viewport;
    private Widget content;

    protected BaseContentWidget(T control, Viewport viewport) {
        this.control = checkNotNull(control);
        this.viewport = checkNotNull(viewport);
    }

    @Override
    public T asNative() {
        return control;
    }

    @Override
    public void applyStyle() {
        if (content != null) {
            content.applyStyle();
        }
    }

    @Override
    public void setContent(Widget content) {
        checkNotNull(content);
        if (this.content != null) {
            this.content.setParent(null);
        }
        this.content = content;
        setNativeContent((N)content.asNative());
        content.setParent(this);
    }

    @Override
    public void scheduleLayout() {
        if (getParent() != null) {
            getParent().scheduleLayout();
        }
    }

    @Override
    public void requestLayout() {
        requestLayout(viewport);
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        if (content != null) {
            measureChild(content, widthSpec, heightSpec);
            updateSize(resolveSize(content.getMeasuredWidth(), widthSpec, true),
                    resolveSize(content.getMeasuredHeight(), heightSpec, false));
        } else {
            super.onMeasure(widthSpec, heightSpec);
        }
    }

    @Override
    public void onLayout() {
        if (content != null) {
            content.layout();
        }
        super.onLayout();
    }

    public Widget getContent() {
        return content;
    }

    protected abstract void setNativeContent(N nativeContent);
}
