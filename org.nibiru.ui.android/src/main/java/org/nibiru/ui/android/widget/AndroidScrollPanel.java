package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

public class AndroidScrollPanel extends AndroidWidget<ScrollView>implements ScrollPanel {
	@Inject
	public AndroidScrollPanel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidScrollPanel(ScrollView control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	@Override
	public void setContent(Widget content) {
		ScrollView control = control();
		control.removeAllViews();
		control.addView((View) content.asNative());
	}

	@Override
	ScrollView buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new ScrollView(context)
				: new ScrollView(context, null, styleResource);
	}
}
