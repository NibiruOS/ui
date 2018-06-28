package org.nibiru.ui.core.api.format;

public interface Format<T> {
    String format(T data);

    T parse(String data);
}
