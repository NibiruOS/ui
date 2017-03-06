package org.nibiru.ui.teavm.builder;

import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.teavm.widget.TeaVmComboBox;

import javax.inject.Inject;

public class TeaVmComboBoxBuilderFactory implements ComboBoxBuilderFactory {
    @Inject
    public TeaVmComboBoxBuilderFactory() {
    }

    @Override
    public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
        return new ComboBoxBuilder<T>(new TeaVmComboBox<T>());
    }
}
