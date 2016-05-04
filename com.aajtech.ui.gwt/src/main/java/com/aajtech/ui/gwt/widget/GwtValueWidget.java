package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;
import com.google.gwt.user.client.ui.Widget;

abstract class GwtValueWidget<W extends Widget, V> extends GwtWidget<W>implements ValueWidget<V> {
	private Value<V> value;

	GwtValueWidget(W control) {
		super(control);
	}

	@Override
	public Value<V> getValue() {
		if (value == null) {
			value = buildValue();
		}
		return value;
	}

	abstract Value<V> buildValue();
}