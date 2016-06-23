package com.aajtech.ui.android.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.android.widget.AndroidComboBox;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilder;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilderFactory;

import android.content.Context;

public class AndroidComboBoxBuilderFactory implements ComboBoxBuilderFactory {

	private final Context context;
	private final StyleResolver styleResolver;

	@Inject
	public AndroidComboBoxBuilderFactory(Context context, StyleResolver styleResolver) {
		this.context = checkNotNull(context);
		this.styleResolver = checkNotNull(styleResolver);
	}
	
	@Override
	public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
		return new ComboBoxBuilder<T>(new AndroidComboBox<T>(context, styleResolver));
	}

}
