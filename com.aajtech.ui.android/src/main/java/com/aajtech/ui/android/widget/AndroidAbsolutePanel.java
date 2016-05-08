package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class AndroidAbsolutePanel extends AndroidContainer<RelativeLayout>implements AbsolutePanel {
	@Inject
	public AndroidAbsolutePanel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidAbsolutePanel(RelativeLayout control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	@Override
	public Position getPosition(Widget child) {
		View childView = (View) child.asNative();
		return new Position() {

			@Override
			public int getX() {
				return getParams(childView).leftMargin;
			}

			@Override
			public Position setX(int x) {
				LayoutParams params = getParams(childView);
				params.leftMargin = x;
				childView.setLayoutParams(params);
				return this;
			}

			@Override
			public int getY() {
				return getParams(childView).topMargin;
			}

			@Override
			public Position setY(int y) {
				LayoutParams params = getParams(childView);
				params.topMargin = y;
				childView.setLayoutParams(params);
				return this;
			}

		};
	}

	@Override
	RelativeLayout buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new RelativeLayout(context) : new RelativeLayout(context, null, styleResource);
	}

	private LayoutParams getParams(View view) {
		LayoutParams params = (LayoutParams) view.getLayoutParams();
		return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}
}
