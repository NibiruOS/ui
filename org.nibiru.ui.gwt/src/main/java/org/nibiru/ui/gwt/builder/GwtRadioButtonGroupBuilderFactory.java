package org.nibiru.ui.gwt.builder;

import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.gwt.widget.GwtRadioButtonGroup;

import javax.inject.Inject;

public class GwtRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Inject
	public GwtRadioButtonGroupBuilderFactory() {
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<>(new GwtRadioButtonGroup<>());
	}
}
