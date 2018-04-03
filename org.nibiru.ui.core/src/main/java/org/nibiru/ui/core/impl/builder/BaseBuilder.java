package org.nibiru.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseBuilder<T> implements ObjectBuilder<T> {
    protected final T object;

    protected BaseBuilder(T object) {
        this.object = checkNotNull(object);
    }

    @Override
    public T object() {
        return object;
    }
}
