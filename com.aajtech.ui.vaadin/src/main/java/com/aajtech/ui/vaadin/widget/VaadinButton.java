package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.api.Registration;
import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ClickHandler;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class VaadinButton extends VaadinWidget<Button>implements com.aajtech.ui.core.api.Button {
	public VaadinButton() {
		super(new Button());
	}

	@Override
	public Value<String> getValue() {
		return new BaseValue<String>() {

			@Override
			public String get() {
				return component.getCaption();
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				component.setCaption(value);
			}
		};
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		ClickListener listener = new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				clickHandler.onClick();
			}
		};
		component.addClickListener(listener);
		return new Registration() {
			@Override
			public void remove() {
				component.removeClickListener(listener);
			}
		};
	}
}