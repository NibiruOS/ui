package org.nibiru.ui.swing.builder;

import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.swing.widget.SwingRadioButtonGroup;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class SwingRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Inject
	public SwingRadioButtonGroupBuilderFactory() {
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		checkNotNull(valueClass);
		return new RadioButtonGroupBuilder<>(new SwingRadioButtonGroup<>());
	}
}
