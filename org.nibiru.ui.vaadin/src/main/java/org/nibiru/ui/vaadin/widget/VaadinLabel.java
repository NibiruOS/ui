package org.nibiru.ui.vaadin.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;

import com.vaadin.ui.Label;

public class VaadinLabel extends VaadinValueWidget<Label, String>implements org.nibiru.ui.core.api.Label {
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
