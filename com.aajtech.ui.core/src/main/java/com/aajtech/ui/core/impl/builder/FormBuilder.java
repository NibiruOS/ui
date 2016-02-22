package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.Widget;

public class FormBuilder extends BaseBuilder<GridPanel> {
	private final Provider<LabelBuilder> labelBuilderProvider;
	private final HorizontalPanelBuilder horizontalPanelBuilder;

	@Inject
	public FormBuilder(GridPanel gridPanel,
			Provider<LabelBuilder> labelBuilderProvider,
			HorizontalPanelBuilder horizontalPanelBuilder) {
		super(gridPanel);
		this.labelBuilderProvider = checkNotNull(labelBuilderProvider);
		this.horizontalPanelBuilder = checkNotNull(horizontalPanelBuilder);
		gridPanel.setColumns(2);
	}

	public FormBuilder field(String label, Widget field) {
		object.add(labelBuilderProvider.get().text(label + " :").build());
		object.add(field);
		return this;
	}

	public FormBuilder button(Widget button) {
		horizontalPanelBuilder.add(button);
		return this;
	}

	@Override
	public GridPanel build() {
		object.add(labelBuilderProvider.get().text("").build());
		object.add(horizontalPanelBuilder.build());
		return super.build();
	}
}
