package org.nibiru.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Style;

public class FormBuilder extends BaseBuilder<GridPanel> {
	private final HorizontalPanelBuilder horizontalPanelBuilder;
	private final Provider<Label> labelProvider;

	@Inject
	public FormBuilder(GridPanel gridPanel, HorizontalPanelBuilder horizontalPanelBuilder,
			Provider<Label> labelProvider) {
		super(gridPanel);
		this.horizontalPanelBuilder = checkNotNull(horizontalPanelBuilder);
		this.labelProvider = checkNotNull(labelProvider);
		gridPanel.setColumns(2);
	}

	public FormBuilder field(Label label, Widget field) {
		label.getValue().set(label.getValue().get() + " :");
		object.add(label);
		object.add(field);
		return this;
	}

	public FormBuilder button(Widget button) {
		horizontalPanelBuilder.add(button);
		return this;
	}

	public FormBuilder style(Style style) {
		object.setStyle(style);
		return this;
	}

	@Override
	public GridPanel build() {
		object.add(labelProvider.get());
		object.add(horizontalPanelBuilder.build());
		return super.build();
	}
}
