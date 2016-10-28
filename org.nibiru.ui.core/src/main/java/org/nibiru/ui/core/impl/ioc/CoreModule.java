package org.nibiru.ui.core.impl.ioc;

import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.impl.GridPanelImpl;
import org.nibiru.ui.core.impl.HorizontalPanelImpl;
import org.nibiru.ui.core.impl.ListWidgetImpl;
import org.nibiru.ui.core.impl.RelativePanelImpl;
import org.nibiru.ui.core.impl.RuleFactoryImpl;
import org.nibiru.ui.core.impl.VerticalPanelImpl;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {
	@Provides
	public HorizontalPanel getHorizontalPanel(HorizontalPanelImpl horizontalPanel) {
		return horizontalPanel;
	}

	@Provides
	public VerticalPanel getVerticalPanel(VerticalPanelImpl verticalPanel) {
		return verticalPanel;
	}

	@Provides
	public GridPanel getGridPanel(GridPanelImpl gridPanel) {
		return gridPanel;
	}

	@Provides
	public ListWidget getListWidget(ListWidgetImpl listWidget) {
		return listWidget;
	}

	@Provides
	public ComboBoxBuilder<String> getStringComboBoxBuilder(ComboBoxBuilderFactory factory) {
		return factory.create(String.class);
	}

	@Provides
	public RelativePanel getRelativePanel(RelativePanelImpl relativePanel) {
		return relativePanel;
	}

	@Provides
	public RelativePanel.RuleFactory getRuleFactory(RuleFactoryImpl factory) {
		return factory;
	}
}
