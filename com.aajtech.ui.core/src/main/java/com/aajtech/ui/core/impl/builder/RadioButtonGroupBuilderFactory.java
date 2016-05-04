package com.aajtech.ui.core.impl.builder;

public interface RadioButtonGroupBuilderFactory {
	<T> RadioButtonGroupBuilder<T> create(Class<T> valueClass);
}
