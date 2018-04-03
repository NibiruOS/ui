package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HasItems;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public interface HasItemsBuilder<T extends HasItems<V> & Widget, V, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B items(Iterable<V> items) {
        checkNotNull(items);
        object().getItems().set(items);
        return getThis();
    }
}


