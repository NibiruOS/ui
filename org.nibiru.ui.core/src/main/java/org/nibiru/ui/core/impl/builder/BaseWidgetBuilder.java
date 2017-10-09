package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Style;

abstract public class BaseWidgetBuilder<T extends Widget,
        B extends BaseWidgetBuilder<T, ?>> extends BaseBuilder<T> {

    protected BaseWidgetBuilder(T control) {
        super(control);
    }

    public B style(Style style) {
        object.setStyle(style);
        return getThis();
    }

    public B visible(Boolean visible) {
        object.getVisible().set(visible);
        return getThis();
    }

    public B tag(Object tag) {
        object.setTag(tag);
        return getThis();
    }

    @SuppressWarnings("unchecked")
    B getThis() {
        return (B) this;
    }
}