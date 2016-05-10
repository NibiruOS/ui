package com.aajtech.ui.core.impl.builder;

import static com.aajtech.ui.core.impl.builder.HorizontalPanelBuilder.horizontalPanel;
import static com.aajtech.ui.core.impl.builder.LabelBuilder.label;
import static com.aajtech.ui.core.impl.builder.SpinnerBuilder.spinner;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.Widget;

public class PopupBuilder extends BaseBuilder<Popup> {
	@Inject
	private static Provider<PopupBuilder> popupBuilderProvider;

	public static PopupBuilder popup() {
		return popupBuilderProvider.get();
	}

	public static Popup popup(Widget content) {
		checkNotNull(content);
		return popup().content(content).build();
	}

	public static Popup loadingPopup(String text) {
		checkNotNull(text);
		return popup(horizontalPanel()
			.add(spinner().build())
			.add(label(text))
			.build());
	}

	@Inject
	public PopupBuilder(Popup widget) {
		super(widget);
	}

	public PopupBuilder content(Widget content) {
		object.setContent(content);
		return this;
	}

	public PopupBuilder autoHide(boolean autoHide) {
		object.setAutoHide(autoHide);
		return this;
	}
}
