package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;

public interface UiCreator {

	LabelBuilder label();

	Label label(String text);

	TextBoxBuilder textBox();

	TextBox textBox(String text);

	VerticalPanelBuilder verticalPanel();

	HorizontalPanelBuilder horizontalPanel();
}