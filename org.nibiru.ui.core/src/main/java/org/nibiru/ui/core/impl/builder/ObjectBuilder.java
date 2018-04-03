package org.nibiru.ui.core.impl.builder;

public interface ObjectBuilder<T>
        extends Builder<T> {
    T object();

    default T build() {
        return object();
    }
}
