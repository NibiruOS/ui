package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ComboBox;

public class ComboBoxBuilder<T>
        extends BaseBuilder<ComboBox<T>>
        implements
        FocusableBuilder<ComboBox<T>, ComboBoxBuilder<T>>,
        HasEnabledBuilder<ComboBox<T>, ComboBoxBuilder<T>>,
        HasItemsBuilder<ComboBox<T>, T, ComboBoxBuilder<T>>,
        ValueWidgetBuilder<ComboBox<T>, T, ComboBoxBuilder<T>> {

    public ComboBoxBuilder(ComboBox<T> control) {
        super(control);
    }
}
