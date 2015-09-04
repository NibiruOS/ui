package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.Label;

public class GwtLabel extends GwtWidget<Label>implements com.aajtech.ui.core.api.Label {
	private final Value<String> value = new BaseValue<String>() {

		@Override
		public String get() {
			return widget.getText();
		}

		@Override
		public void set(String value) {
			widget.setText(value);
		}

		@Override
		public Type<String> getType() {
			return JavaType.STRING;
		}
	};

	public GwtLabel() {
		super(new Label());
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
