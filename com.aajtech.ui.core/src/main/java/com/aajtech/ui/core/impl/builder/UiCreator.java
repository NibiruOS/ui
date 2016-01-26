package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;

public interface UiCreator {

	LabelBuilder label();

	Label label(String text);

	TextBoxBuilder textBox();

	TextBox textBox(String text);

	PasswordBoxBuilder passwordBox();

	PasswordBox passwordBox(String text);

	VerticalPanelBuilder verticalPanel();

	HorizontalPanelBuilder horizontalPanel();

	ButtonBuilder button();

	Button button(String text, ClickHandler clickHandler);
}