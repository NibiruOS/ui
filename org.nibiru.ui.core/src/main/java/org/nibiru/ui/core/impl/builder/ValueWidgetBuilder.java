package org.nibiru.ui.core.impl.builder;

import org.nibiru.model.core.impl.bind.Bind;
import org.nibiru.ui.core.api.ValueWidget;

import javax.annotation.Nullable;

public interface ValueWidgetBuilder<T extends ValueWidget<V>, V, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B value(V value) {
        object().getValue().set(value);
        return getThis();
    }

    default B addObserver(Runnable observer) {
        object().getValue().addObserver(observer);
        return getThis();
    }

    default Bind<V> bind() {
        return Bind.on(object().getValue());
    }

    default T build(@Nullable V value) {
        return value(value).build();
    }
}
