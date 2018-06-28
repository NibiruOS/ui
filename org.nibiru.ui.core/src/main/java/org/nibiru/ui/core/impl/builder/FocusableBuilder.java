package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Focusable;
import org.nibiru.ui.core.api.Widget;

public interface FocusableBuilder<T extends Widget & Focusable, B extends FocusableBuilder<T, ?>>
        extends WidgetBuilder<T, B> {
    default B focus() {
        object().requestFocus();
        return getThis();
    }
}
