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
        setNativeContent((N) content.asNative());
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
    public void onLayout() {
        if (content != null) {
            content.layout();
        }
        setNativeSize(getMeasuredWidth(), getMeasuredHeight());
    }

    protected Widget getContent() {
        return content;
    }

    abstract protected void setNativeContent(N nativeContent);

    abstract protected void setNativeSize(int width, int height);
}
