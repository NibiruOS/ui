package org.nibiru.ui.vaadin.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class VaadinButton extends VaadinWidget<Button> implements org.nibiru.ui.core.api.Button {
	public VaadinButton() {
		this(new Button());
	}

	public VaadinButton(Button button) {
		super(button);
	}

	@Override
	public Value<String> getValue() {
		return new BaseValue<String>() {

			@Override
			public String get() {
				return control.getCaption();
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				control.setCaption(value);
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
		control.addClickListener(listener);
		return new Registration() {
			@Override
			public void remove() {
				control.removeClickListener(listener);
			}
		};
	}
}
