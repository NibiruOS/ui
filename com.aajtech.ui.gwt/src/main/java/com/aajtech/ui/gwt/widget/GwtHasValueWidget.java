package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.ValueWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

abstract class GwtHasValueWidget<W extends Widget & HasValue<V>, V> extends GwtValueWidget<W, V>
		implements ValueWidget<V> {
	private final Type<V> type;

	GwtHasValueWidget(W widget, Type<V> type) {
		super(widget);
		this.type = checkNotNull(type);
	}

	@Override
	Value<V> buildValue() {
		return new HasValueAdapter<V>(control, type);
	}
}
