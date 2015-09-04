package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.google.gwt.user.client.TakesValue;

public class TakesValueAdapter<T> extends BaseValue<T> {
	private final TakesValue<T> takesValue;
	private final Type<T> type;

	public TakesValueAdapter(TakesValue<T> takesValue, Type<T> type) {
		this.takesValue = checkNotNull(takesValue);
		this.type = checkNotNull(type);
	}

	@Override
	public T get() {
		return takesValue.getValue();
	}

	@Override
	public void set(@Nullable T value) {
		takesValue.setValue(value);

	}

	@Override
	public Type<T> getType() {
		return type;
	}
}
