package org.nibiru.ui.gwt.builder;

import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.gwt.widget.GwtComboBox;

public class GwtComboBoxBuilderFactory implements ComboBoxBuilderFactory{
	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<T>(new GwtComboBox<T>());
	}

}
