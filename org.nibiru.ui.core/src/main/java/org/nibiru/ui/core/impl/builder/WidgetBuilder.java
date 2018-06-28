package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Style;

public interface WidgetBuilder<T extends Widget, B extends WidgetBuilder<T, ?>>
        extends ObjectBuilder<T>, ChainBuilder<B> {

    default B style(Style style) {
        object().setStyle(style);
        return getThis();
    }

    default B visible(boolean visible) {
        object().getVisible().set(visible);
        return getThis();
    }

    default B tag(Object tag) {
        object().setTag(tag);
        return getThis();
    }
}