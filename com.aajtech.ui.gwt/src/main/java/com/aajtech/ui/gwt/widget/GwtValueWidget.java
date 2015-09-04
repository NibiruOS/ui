package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Widget;

abstract class GwtValueWidget<W extends Widget & TakesValue<T>, T> extends GwtWidget<W>implements ValueWidget<T> {
	private final Value<T> value;

	GwtValueWidget(W widget, Type<T> type) {
		super(widget);
		this.value = new TakesValueAdapter<>(widget, type);
	}

	@Override
	public Value<T> getValue() {
		return value;
	}
}
