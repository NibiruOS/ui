package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.HasText;

public class HasTextAdapter extends BaseValue<String> {
	private final HasText control;

	public HasTextAdapter(HasText control) {
		this.control = checkNotNull(control);
	}

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
}
