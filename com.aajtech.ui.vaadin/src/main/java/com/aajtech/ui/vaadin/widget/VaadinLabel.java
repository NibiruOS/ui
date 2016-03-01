package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.TextStyle;
import com.vaadin.ui.Label;

public class VaadinLabel extends VaadinValueWidget<Label, String>implements com.aajtech.ui.core.api.Label {
	public VaadinLabel() {
		this(new Label());
		setStyle(TextStyle.DEFAULT);
	}

	public VaadinLabel(Label label) {
		super(label, JavaType.STRING, label.getValue());
	}
}
