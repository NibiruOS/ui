package com.aajtech.ui.android.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.HasClickHandler;
import com.aajtech.ui.core.api.Widget;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;

abstract class AndroidWidget<T extends View> implements Widget, HasClickHandler {
	final T control;
	private final StyleResolver styleResolver;
	private Registration clickRegistration;

	AndroidWidget(T view, StyleResolver styleResolver) {
		this.control = checkNotNull(view);
		this.styleResolver = checkNotNull(styleResolver);
	}

	@Override
	public T asNative() {
		return control;
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickRegistration != null) {
			clickRegistration.remove();
		}
		control.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		clickRegistration = new Registration() {
			@Override
			public void remove() {
				control.setOnClickListener(null);
			}
		};
		return clickRegistration;
	}

	@Override
	public void addStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		Context context =  control.getContext();
		if (context instanceof ContextThemeWrapper) {
			ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
			contextThemeWrapper.setTheme(styleResolver.resolveStyle(styleName));
		}
	}
}
