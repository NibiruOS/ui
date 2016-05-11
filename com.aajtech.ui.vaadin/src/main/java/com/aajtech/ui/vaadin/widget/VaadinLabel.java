package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.api.Registration;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ClickHandler;
import com.vaadin.ui.Label;

public class VaadinLabel extends VaadinValueWidget<Label, String>implements com.aajtech.ui.core.api.Label {
	public VaadinLabel() {
		this(new Label());
	}

	public VaadinLabel(Label label) {
		super(label, JavaType.STRING, label.getValue());
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
