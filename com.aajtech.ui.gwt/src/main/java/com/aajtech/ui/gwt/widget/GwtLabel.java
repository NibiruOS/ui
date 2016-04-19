package com.aajtech.ui.gwt.widget;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.Label;

public class GwtLabel extends GwtWidget<Label> implements com.aajtech.ui.core.api.Label {
	private final Value<String> value = new BaseValue<String>() {

		@Override
		@Nullable 
		public String get() {
			return control.getText();
		}

		@Override
		protected void setValue(@Nullable String value) {
			control.setText(value);
		}

		@Override
		public Type<String> getType() {
			return JavaType.STRING;
		}
	};

	public GwtLabel() {
		this(new Label());
	}

	public GwtLabel(Label label) {
		super(label);
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
