package org.nibiru.ui.ios.builder;

import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.ios.widget.IOSRadioButtonGroup;

import javax.inject.Inject;

public class IOSRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Inject
	public IOSRadioButtonGroupBuilderFactory() {
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<T>(new IOSRadioButtonGroup<T>());
	}
}
