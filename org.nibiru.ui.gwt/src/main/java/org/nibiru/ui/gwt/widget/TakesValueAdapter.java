package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.TakesValue;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class TakesValueAdapter<T> extends BaseValue<T> {
	private final TakesValue<T> takesValue;
	private final Type<T> type;

	public TakesValueAdapter(TakesValue<T> takesValue, Type<T> type) {
		this.takesValue = checkNotNull(takesValue);
		this.type = checkNotNull(type);
	}

	@Override
	@Nullable
	public T get() {
		return takesValue.getValue();
	}

	@Override
	protected void setValue(@Nullable T value) {
		takesValue.setValue(value);
	}

	@Override
	public Type<T> getType() {
		return type;
	}
}
