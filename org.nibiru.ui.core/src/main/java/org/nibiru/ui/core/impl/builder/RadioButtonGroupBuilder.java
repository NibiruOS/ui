package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.RadioButtonGroup;

public class RadioButtonGroupBuilder<T>
        extends BaseBuilder<RadioButtonGroup<T>>
        implements
        HasEnabledBuilder<RadioButtonGroup<T>, RadioButtonGroupBuilder<T>>,
        HasItemsBuilder<RadioButtonGroup<T>, T, RadioButtonGroupBuilder<T>>,
        ValueWidgetBuilder<RadioButtonGroup<T>, T, RadioButtonGroupBuilder<T>> {

    public RadioButtonGroupBuilder(RadioButtonGroup<T> control) {
        super(control);
    }

    public RadioButtonGroupBuilder<T> enabled(boolean enabled) {
        object.getEnabled().set(enabled);
        return this;
    }
}
