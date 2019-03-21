package org.nibiru.ui.ios.builder;

import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.ios.widget.IOSComboBox;

import javax.inject.Inject;

public class IOSComboBoxBuilderFactory implements ComboBoxBuilderFactory {
	@Inject
	public IOSComboBoxBuilderFactory() {
	}

	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<>(new IOSComboBox<>());
	}
}
