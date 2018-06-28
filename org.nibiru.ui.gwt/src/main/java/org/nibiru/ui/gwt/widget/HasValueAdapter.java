package org.nibiru.ui.gwt.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;

import org.nibiru.model.core.api.Type;

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
