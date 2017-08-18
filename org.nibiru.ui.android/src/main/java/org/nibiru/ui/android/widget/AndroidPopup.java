package org.nibiru.ui.android.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseContentWidget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidPopup extends BaseContentWidget<Dialog, View> implements Popup {
    @Inject
    public AndroidPopup(Context context, Viewport viewport) {
        this(new Dialog(checkNotNull(context)), viewport);
        control.requestWindowFeature(Window.FEATURE_NO_TITLE);
        control.setCanceledOnTouchOutside(false);
    }

    public AndroidPopup(Dialog control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    protected void setNativeContent(View nativeContent) {
        control.setContentView(nativeContent);
    }

    @Override
    public void show() {
        control.show();
    }

    @Override
    public void hide() {
        control.dismiss();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
        control.setCanceledOnTouchOutside(autoHide);
    }
}
