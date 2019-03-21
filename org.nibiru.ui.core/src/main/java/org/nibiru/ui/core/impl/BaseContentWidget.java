package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.HasContent;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseContentWidget<T, N> extends BaseParentWidget implements HasContent {
    protected final T control;
    private Widget content;

    protected BaseContentWidget(T control,
                                Viewport viewport,
                                Looper looper) {
        super(viewport, looper);
        this.control = checkNotNull(control);
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
