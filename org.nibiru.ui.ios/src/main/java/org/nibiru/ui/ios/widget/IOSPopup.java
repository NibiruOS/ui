package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BasePopup;

import javax.inject.Inject;

import apple.uikit.UIView;

public class IOSPopup extends BasePopup<Overlay, UIView> implements Popup {

    @Inject
    public IOSPopup(Viewport viewport) {
        super(Overlay.create(), viewport);
    }

    @Override
    public void show() {
        control.show();
        requestLayout();
    }

    @Override
    public void hide() {
        control.hide();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
        control.setAutoHide(autoHide);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        control.centerContent();
    }

    @Override
    protected void setNativeContent(UIView nativeContent) {
        control.setContent(nativeContent);
        control.centerContent();
    }

    @Override
    protected void setNativeSize(int width, int height) {
        if (getContent() != null) {
            WidgetUtils.setNativeSize((UIView) getContent().asNative(), width, height);
        }
    }
}
