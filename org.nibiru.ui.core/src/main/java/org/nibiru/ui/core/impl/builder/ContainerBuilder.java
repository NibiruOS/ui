package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

public interface ContainerBuilder<T extends Container, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B add(Widget child) {
        object().add(child);
        return getThis();
    }
}
