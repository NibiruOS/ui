package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Style;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public interface WidgetBuilder<T extends Widget, B extends WidgetBuilder<T, ?>>
        extends ObjectBuilder<T>, ChainBuilder<B> {

    default B style(Style style) {
        checkNotNull(style);
        object().setStyle(style);
        return getThis();
    }

    default B style(Builder<? extends Style> style) {
        checkNotNull(style);
        return style(style.build());
    }

    default B visible(boolean visible) {
        object().getVisible().set(visible);
        return getThis();
    }

    default B tag(@Nullable Object tag) {
        object().setTag(tag);
        return getThis();
    }
}