package org.nibiru.ui.dotnet.builder;

import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.dotnet.widget.DotNetRadioButtonGroup;

import javax.inject.Inject;

public class DotNetRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Inject
	public DotNetRadioButtonGroupBuilderFactory() {
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<T>(new DotNetRadioButtonGroup<T>());
	}
}
