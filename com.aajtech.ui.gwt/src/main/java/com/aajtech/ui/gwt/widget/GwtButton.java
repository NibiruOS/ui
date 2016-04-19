package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Registration;
import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.Button;

public class GwtButton extends GwtWidget<Button>implements com.aajtech.ui.core.api.Button {
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
	private HasClickHandlersAdapter hasClickHandlersAdapter;
	

	public GwtButton() {
		this(new Button());
	}

	public GwtButton(Button button) {
		super(button);
		hasClickHandlersAdapter = new HasClickHandlersAdapter(control);
	}

	@Override
	public Value<String> getValue() {
		return value;
	}

	@Override
	public Registration setClickHandler(com.aajtech.ui.core.api.ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		return hasClickHandlersAdapter.setClickHandler(clickHandler);
	}
}
