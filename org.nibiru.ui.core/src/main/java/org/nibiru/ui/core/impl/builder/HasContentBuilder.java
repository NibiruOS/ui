package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HasContent;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public interface HasContentBuilder<T extends HasContent, B extends HasContentBuilder<T, ?>>
        extends ObjectBuilder<T>, ChainBuilder<B> {

    default B content(Widget content) {
        checkNotNull(content);
        object().setContent(content);
        return getThis();
    }

    default B content(Builder<? extends Widget> content) {
        checkNotNull(content);
        return content(content.build());
    }

    default T build(Widget content) {
        checkNotNull(content);
        return content(content).build();
    }

    default T build(Builder<? extends Widget> content) {
        checkNotNull(content);
        return build(content.build());
    }
}
