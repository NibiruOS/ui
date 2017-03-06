package org.nibiru.ui.teavm.builder;

import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.teavm.widget.TeaVmRadioButtonGroup;

import javax.inject.Inject;

public class TeaVmRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Inject
	public TeaVmRadioButtonGroupBuilderFactory() {
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<T>(new TeaVmRadioButtonGroup<T>());
	}
}
