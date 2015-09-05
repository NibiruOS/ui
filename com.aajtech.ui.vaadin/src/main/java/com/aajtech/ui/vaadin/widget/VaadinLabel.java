package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.impl.java.JavaType;
import com.vaadin.ui.Label;

public class VaadinLabel extends VaadinValueWidget<Label, String>implements com.aajtech.ui.core.api.Label {
	private static final long serialVersionUID = 6816571039915329035L;

	public VaadinLabel() {
		super(new Label(), JavaType.STRING);
	}
}
