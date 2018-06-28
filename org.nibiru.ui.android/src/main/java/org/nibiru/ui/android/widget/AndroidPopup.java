package org.nibiru.ui.android.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BasePopup;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidPopup extends BasePopup<Dialog, View> implements Popup {
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
    public void show() {
        control.show();
        requestLayout();
    }

    @Override
    public void hide() {
        control.dismiss();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
        control.setCanceledOnTouchOutside(autoHide);
    }

    @Override
    protected void setNativeContent(View nativeContent) {
        control.setContentView(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        if (getContent() != null) {
            WidgetUtils.setNativeSize((View) getContent().asNative(), width, height);
        }
    }
}
