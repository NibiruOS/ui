package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.Focusable;

import org.nibiru.ui.core.api.TypedWidget;

public interface GwtFocusable<T extends Focusable>
        extends TypedWidget<T>, org.nibiru.ui.core.api.Focusable {

    @Override
    default void requestFocus() {
        asNative().setFocus(true);
    }
}
