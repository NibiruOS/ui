package org.nibiru.ui.dotnet.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

import cli.System.Windows.FrameworkElement;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class DotNetValueWidget<T extends FrameworkElement, V>
        extends DotNetWidget<T>
        implements ValueWidget<V> {
    private final Value<V> value;

    DotNetValueWidget(T view) {
        super(view);
        this.value = checkNotNull(buildValue());
    }

    abstract Value<V> buildValue();

    @Override
    public Value<V> getValue() {
        return value;
    }
}
