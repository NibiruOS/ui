package com.aajtech.ui.android.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;
import com.aajtech.ui.core.api.Widget;

import android.view.View;

abstract class AndroidWidget<T extends View> implements Widget, HasClickHandler {
	final T view;
	private Registration clickRegistration;

	AndroidWidget(T view) {
		this.view = checkNotNull(view);
	}

	@Override
	public T asNative() {
		return view;
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickRegistration != null) {
			clickRegistration.remove();
		}
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		clickRegistration = new Registration() {
			@Override
			public void remove() {
				view.setOnClickListener(null);
			}
		};
		return clickRegistration;
	}

}
