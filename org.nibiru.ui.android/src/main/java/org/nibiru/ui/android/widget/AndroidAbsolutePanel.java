package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class AndroidAbsolutePanel extends AndroidContainer<RelativeLayout> implements AbsolutePanel {
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
				return pxToDp(getLayoutParams(childView).leftMargin);
			}

			@Override
			public Position setX(int x) {
				LayoutParams params = getLayoutParams(childView);
				params.leftMargin = dpToPx(x);
				childView.setLayoutParams(params);
				return this;
			}

			@Override
			public int getY() {
				return pxToDp(getLayoutParams(childView).topMargin);
			}

			@Override
			public Position setY(int y) {
				LayoutParams params = getLayoutParams(childView);
				params.topMargin = dpToPx(y);
				childView.setLayoutParams(params);
				return this;
			}

		};
	}

	@Override
	RelativeLayout buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new RelativeLayout(context) : new RelativeLayout(context, null, styleResource);
	}

	private LayoutParams getLayoutParams(View view) {
		LayoutParams params = (LayoutParams) view.getLayoutParams();
		return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}

	@Override
	public void requestLayout() {
	}
}
