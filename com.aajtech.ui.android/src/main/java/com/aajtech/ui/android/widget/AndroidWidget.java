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
	private final Context context;
	private T control;
	private final StyleResolver styleResolver;
	private Registration clickRegistration;
	private int styleResource;

	AndroidWidget(T control, StyleResolver styleResolver) {
		this.control = checkNotNull(control);
		this.styleResolver = checkNotNull(styleResolver);
		context = null;
	}

	AndroidWidget(Context context, StyleResolver styleResolver) {
		this.context = checkNotNull(context);
		this.styleResolver = checkNotNull(styleResolver);
	}

	@Override
	public T asNative() {
		return control();
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickRegistration != null) {
			clickRegistration.remove();
		}
		control().setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		clickRegistration = new Registration() {
			@Override
			public void remove() {
				control().setOnClickListener(null);
			}
		};
		return clickRegistration;
	}

	@Override
	public void addStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		styleResource = styleResolver.resolveStyle(styleName);
	}

	T control() {
		if (control == null) {
			control = buildControl(styleResource == 0 ? context : new ContextThemeWrapper(context, styleResource),
					styleResource);
		}
		return control;
	}

	abstract T buildControl(Context context, int styleResource);
}
