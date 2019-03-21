package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BasePopup;
import org.nibiru.ui.gwt.resource.Resources;

import javax.inject.Inject;

public class GwtPopup extends BasePopup<PopupPanel, Widget>
        implements Popup {
    @Inject
    public GwtPopup(Resources resources,
                    Viewport viewport,
                    Looper looper) {
        this(new PopupPanel(), viewport, looper);
        control.setGlassEnabled(true);
        resources.css().ensureInjected();
        control.setGlassStyleName(resources.css().popupGlass());
    }

    public GwtPopup(PopupPanel control,
                    Viewport viewport,
                    Looper looper) {
        super(control, viewport, looper);
    }

    @Override
    public void show() {
        control.show();
        requestLayout();
    }

    @Override
    public void onLayout() {
        super.onLayout();
        control.center();
    }

    @Override
    public void hide() {
        control.hide();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
        control.setAutoHideEnabled(autoHide);
    }

    @Override
    protected void setNativeContent(com.google.gwt.user.client.ui.Widget nativeContent) {
        control.clear();
        control.add(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        if (getContent() != null) {
            WidgetUtils.setNativeSize((Widget) getContent().asNative(), width, height);
        }
        WidgetUtils.setNativeSize(control, width, height);
    }
}
