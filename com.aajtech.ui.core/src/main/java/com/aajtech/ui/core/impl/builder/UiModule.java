package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Color;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;

public abstract class UiModule implements UiCreator {
	private final UiCreator uiBuilder;

	public UiModule(UiBuilder uiBuilder) {
		this.uiBuilder = checkNotNull(uiBuilder);
	}

	@Override
	public LabelBuilder label() {
		return uiBuilder.label();
	}

	@Override
	public Label label(String text) {
		return uiBuilder.label(text);
	}

	@Override
	public TextBoxBuilder textBox() {
		return uiBuilder.textBox();
	}

	@Override
	public TextBox textBox(String text) {
		return uiBuilder.textBox(text);
	}

	@Override
	public PasswordBoxBuilder passwordBox() {
		return uiBuilder.passwordBox();
	}

	@Override
	public PasswordBox passwordBox(String text) {
		return uiBuilder.passwordBox(text);
	}

	@Override
	public VerticalPanelBuilder verticalPanel() {
		return uiBuilder.verticalPanel();
	}

	@Override
	public HorizontalPanelBuilder horizontalPanel() {
		return uiBuilder.horizontalPanel();
	}

	@Override
	public ButtonBuilder button() {
		return uiBuilder.button();
	}

	@Override
	public Button button(String text, ClickHandler clickHandler) {
		return uiBuilder.button(text, clickHandler);
	}

	@Override
	public ListWidget list() {
		return uiBuilder.list();
	}

	@Override
	public StyleBuilder style() {
		return uiBuilder.style();
	}

	@Override
	public Color color(int red, int green, int blue) {
		return uiBuilder.color(red, green, blue);
	}

	@Override
	public Color color(int red, int green, int blue, int alpha) {
		return uiBuilder.color(red, green, blue, alpha);
	}
}
