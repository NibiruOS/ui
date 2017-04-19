package org.nibiru.ui.android.builder;

import android.content.Context;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.android.widget.AndroidComboBox;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

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
