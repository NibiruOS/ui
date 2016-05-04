package com.aajtech.ui.gwt.builder;

import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilder;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import com.aajtech.ui.gwt.widget.GwtRadioButtonGroup;

public class GwtRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<T>(new GwtRadioButtonGroup<T>());
	}
}
