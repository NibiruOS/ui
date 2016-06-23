package com.aajtech.ui.android.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.android.widget.AndroidRadioButtonGroup;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilder;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilderFactory;

import android.content.Context;

public class AndroidRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
	private final Context context;
	private final StyleResolver styleResolver;

	@Inject
	public AndroidRadioButtonGroupBuilderFactory(Context context, StyleResolver styleResolver) {
		this.context = checkNotNull(context);
		this.styleResolver = checkNotNull(styleResolver);
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
		return new RadioButtonGroupBuilder<T>(new AndroidRadioButtonGroup<T>(context, styleResolver));
	}
}
