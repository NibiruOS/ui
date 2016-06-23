package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.Button;

import android.content.Context;

public class AndroidButton extends AndroidLabel implements Button {
	@Inject
	public AndroidButton(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidButton(android.widget.Button button, StyleResolver styleResolver) {
		super(button, styleResolver);
	}

	@Override
	android.widget.Button buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new android.widget.Button(context)
				: new android.widget.Button(context, null, styleResource);
	}
}
