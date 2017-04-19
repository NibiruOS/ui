package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class PopupBuilder extends BaseBuilder<Popup> {
	private final Provider<HorizontalPanelBuilder> horizontalPanel;
	private final Provider<LabelBuilder> label;
	private final Provider<SpinnerBuilder> spinner;

	@Inject
	public PopupBuilder(Popup widget,
			Provider<HorizontalPanelBuilder> horizontalPanel,
			Provider<LabelBuilder> label,
			Provider<SpinnerBuilder> spinner) {
		super(widget);
		this.horizontalPanel = checkNotNull(horizontalPanel);
		this.label = checkNotNull(label);
		this.spinner = checkNotNull(spinner);
	}

	public PopupBuilder content(Widget content) {
		object.setContent(content);
		return this;
	}

	public PopupBuilder autoHide(boolean autoHide) {
		object.setAutoHide(autoHide);
		return this;
	}

	public Popup build(Widget content) {
		checkNotNull(content);
		return content(content).build();
	}

	public Popup loadingPopup(String text) {
		checkNotNull(text);
		return build(horizontalPanel.get()
			.add(spinner.get().build())
			.add(label.get().build(text))
			.build());
	}
}
