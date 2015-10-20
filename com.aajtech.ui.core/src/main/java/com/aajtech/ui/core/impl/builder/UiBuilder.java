package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;

public class UiBuilder implements UiCreator {
	private final Provider<LabelBuilder> labelBuilderProvider;
	private final Provider<TextBoxBuilder> textBoxBuilderProvider;
	private final Provider<VerticalPanelBuilder> verticalPanelBuilderProvider;
	private final Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider;
	private final Provider<ButtonBuilder> buttonBuilderProvider;

	@Inject
	public UiBuilder(Provider<LabelBuilder> labelBuilderProvider, Provider<TextBoxBuilder> textBoxBuilderProvider,
			Provider<VerticalPanelBuilder> verticalPanelBuilderProvider,
			Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider,
			Provider<ButtonBuilder> buttonBuilderProvider) {
		this.labelBuilderProvider = checkNotNull(labelBuilderProvider);
		this.textBoxBuilderProvider = checkNotNull(textBoxBuilderProvider);
		this.verticalPanelBuilderProvider = checkNotNull(verticalPanelBuilderProvider);
		this.horizontalPanelBuilderProvider = checkNotNull(horizontalPanelBuilderProvider);
		this.buttonBuilderProvider = checkNotNull(buttonBuilderProvider);
	}

	@Override
	public LabelBuilder label() {
		return labelBuilderProvider.get();
	}

	@Override
	public Label label(String text) {
		return label().text(text).build();
	}

	@Override
	public TextBoxBuilder textBox() {
		return textBoxBuilderProvider.get();
	}

	@Override
	public TextBox textBox(String text) {
		return textBox().text(text).build();
	}

	@Override
	public VerticalPanelBuilder verticalPanel() {
		return verticalPanelBuilderProvider.get();
	}

	@Override
	public HorizontalPanelBuilder horizontalPanel() {
		return horizontalPanelBuilderProvider.get();
	}

	@Override
	public ButtonBuilder button() {
		return buttonBuilderProvider.get();
	}

	@Override
	public Button button(String text, ClickHandler clickHandler) {
		return button().text(text).onClick(clickHandler).build();
	}
}
