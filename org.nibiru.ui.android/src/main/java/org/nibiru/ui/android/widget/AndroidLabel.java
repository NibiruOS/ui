package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.TextView;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

public class AndroidLabel extends AndroidValueWidget<TextView, String> implements Label {
	// TODO: Fix this "magic".
	private static int MAGIC_PADDING = 2;

	@Inject
	public AndroidLabel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidLabel(TextView textView, StyleResolver styleResolver) {
		super(textView, styleResolver);
	}

	@Override
	public void applyStyle() {
		super.applyStyle();
		if (getStyle() instanceof TextStyle) {
			TextStyle textStyle = (TextStyle) getStyle();
			control.setTextColor(colorToNative(textStyle.getTextColor()));
		}
	}

	@Override
	TextView buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new TextView(context)
				: new TextView(context, null, styleResource);
	}

	@Override
	Value<String> buildValue() {
		return new LabelValue(control());
	}

	@Override
	protected int getNativeWidth() {
		return super.getNativeWidth() + MAGIC_PADDING;
	}
}
