package com.aajtech.ui.core.impl.builder;

public interface ComboBoxBuilderFactory {
	<T> ComboBoxBuilder<T> create(Class<T> valueClass);
}
