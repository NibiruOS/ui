package org.nibiru.ui.core.api;

public interface TypedWidget<T>
        extends Widget {
    T asNative();
}
