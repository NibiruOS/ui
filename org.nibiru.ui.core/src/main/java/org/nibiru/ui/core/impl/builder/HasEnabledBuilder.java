package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HasEnabled;
import org.nibiru.ui.core.api.Widget;

public interface HasEnabledBuilder<T extends HasEnabled & Widget, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B enabled(boolean enabled) {
        object().getEnabled().set(enabled);
        return getThis();
    }
}
