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
	final T view;
	private final StyleResolver styleResolver;
	private Registration clickRegistration;

	AndroidWidget(T view, StyleResolver styleResolver) {
		this.view = checkNotNull(view);
		this.styleResolver = checkNotNull(styleResolver);
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

	@Override
	public void addStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		Context context =  view.getContext();
		if (context instanceof ContextThemeWrapper) {
			ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
			contextThemeWrapper.setTheme(styleResolver.resolveStyle(styleName));
		}
	}
}
