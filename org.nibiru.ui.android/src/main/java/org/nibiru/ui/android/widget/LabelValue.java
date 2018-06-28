package org.nibiru.ui.android.widget;

import android.widget.TextView;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;

import javax.annotation.Nullable;

class LabelValue extends BaseValue<String> {
	private final TextView view;

	LabelValue(TextView view) {
		this.view = view;
	}

	@Override
	@Nullable
	public String get() {
		return view.getText().toString();
	}

	@Override
	protected void setValue(@Nullable String value) {
		view.setText(value);
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}