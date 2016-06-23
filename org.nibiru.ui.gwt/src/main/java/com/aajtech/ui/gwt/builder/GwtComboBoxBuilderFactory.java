package com.aajtech.ui.gwt.builder;

import com.aajtech.ui.core.impl.builder.ComboBoxBuilder;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilderFactory;
import com.aajtech.ui.gwt.widget.GwtComboBox;

public class GwtComboBoxBuilderFactory implements ComboBoxBuilderFactory{
	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<T>(new GwtComboBox<T>());
	}

}
