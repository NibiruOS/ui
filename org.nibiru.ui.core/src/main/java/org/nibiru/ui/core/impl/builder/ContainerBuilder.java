package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public interface ContainerBuilder<T extends Container, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B add(Widget child) {
        checkNotNull(child);
        object().add(child);
        return getThis();
    }

    default B add(Builder<? extends Widget> child) {
        checkNotNull(child);
        return add(child.build());
    }
}
