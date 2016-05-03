package com.aajtech.ui.android.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.Widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

public class AndroidPopup implements Popup {
	private final Dialog dialog;

	@Inject
	public AndroidPopup(Context context) {
		checkNotNull(context);
		dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
	}

	@Override
	public void show() {
		dialog.show();
	}

	@Override
	public void hide() {
		dialog.dismiss();
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		dialog.setContentView((View) content.asNative());
	}

	@Override
	public void setAutoHide(boolean autoHide) {
        dialog.setCanceledOnTouchOutside(autoHide);
	}
}
