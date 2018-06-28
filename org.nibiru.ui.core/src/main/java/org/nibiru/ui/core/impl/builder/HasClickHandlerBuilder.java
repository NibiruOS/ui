package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.Widget;

import static com.google.common.base.Preconditions.checkNotNull;

public interface HasClickHandlerBuilder<T extends Widget & HasClickHandler, B extends WidgetBuilder<T, ?>>
        extends WidgetBuilder<T, B> {

    default B onClick(ClickHandler clickHandler) {
        checkNotNull(clickHandler);
        object().setClickHandler(clickHandler);
        return getThis();
    }
}
