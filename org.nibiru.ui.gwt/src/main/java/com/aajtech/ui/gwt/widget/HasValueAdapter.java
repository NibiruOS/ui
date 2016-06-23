package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Type;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;

public class HasValueAdapter<T> extends TakesValueAdapter<T> {
	public HasValueAdapter(HasValue<T> hasValue, Type<T> type) {
		super(hasValue, type);
		hasValue.addValueChangeHandler(new ValueChangeHandler<T>() {
			@Override
			public void onValueChange(ValueChangeEvent<T> event) {
				notifyObservers();
			}
		});
	}
}
