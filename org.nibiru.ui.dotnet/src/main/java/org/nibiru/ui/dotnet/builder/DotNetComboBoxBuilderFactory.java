package org.nibiru.ui.dotnet.builder;

import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.dotnet.widget.DotNetComboBox;

import javax.inject.Inject;

public class DotNetComboBoxBuilderFactory implements ComboBoxBuilderFactory {
	@Inject
	public DotNetComboBoxBuilderFactory() {
	}

	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<T>(new DotNetComboBox<T>());
	}
}
