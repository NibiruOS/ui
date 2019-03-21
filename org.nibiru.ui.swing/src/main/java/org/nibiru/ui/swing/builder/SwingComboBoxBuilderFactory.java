package org.nibiru.ui.swing.builder;

import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.swing.widget.SwingComboBox;

import javax.inject.Inject;

public class SwingComboBoxBuilderFactory implements ComboBoxBuilderFactory {
	@Inject
	public SwingComboBoxBuilderFactory() {
	}

	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<>(new SwingComboBox<>());
	}
}
