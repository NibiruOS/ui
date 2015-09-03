package com.aajtech.ui.showcase.app;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.VerticalPanel;

public class MainPage {
	private final Provider<Label> labelProvider;
	private final Provider<VerticalPanel> verticalPanelProvider;

	@Inject
	public MainPage(Provider<Label> labelProvider, Provider<VerticalPanel> verticalPanelProvider) {
		this.labelProvider = checkNotNull(labelProvider);
		this.verticalPanelProvider = checkNotNull(verticalPanelProvider);
	}

	public Object buildPage() {
		Label label = labelProvider.get();
		label.getValue().set("In your face, Xamarin Forms!");

		VerticalPanel verticalPanel = verticalPanelProvider.get();
		verticalPanel.add(label);

		return verticalPanel.asNative();
	}
}
