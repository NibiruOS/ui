package org.nibiru.ui.core.impl.builder;


import org.nibiru.ui.core.api.HasContent;
import org.nibiru.ui.core.api.Widget;

public abstract class BaseContentWidgetBuilder<T extends HasContent & Widget, B extends BaseWidgetBuilder<T, ?>>
        extends BaseWidgetBuilder<T, B> {
    protected BaseContentWidgetBuilder(T control) {
        super(control);
    }

    public B content(Widget content) {
        object.setContent(content);
        return getThis();
    }

    public T build(Widget content) {
        return content(content).build();
    }
}
