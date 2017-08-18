package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.PopupPanel;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseContentWidget;
import org.nibiru.ui.gwt.resource.Resources;

import javax.inject.Inject;

public class GwtPopup extends BaseContentWidget<PopupPanel, com.google.gwt.user.client.ui.Widget>
        implements Popup {
    @Inject
    public GwtPopup(Resources resources, Viewport viewport) {
        this(new PopupPanel(), viewport);
        control.setGlassEnabled(true);
        resources.css().ensureInjected();
        control.setGlassStyleName(resources.css().popupGlass());
    }

    public GwtPopup(PopupPanel control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    protected void setNativeContent(com.google.gwt.user.client.ui.Widget nativeContent) {
        control.clear();
        control.add(nativeContent);
    }

    @Override
    public void show() {
        control.center();
        control.show();
    }

    @Override
    public void hide() {
        control.hide();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
        control.setAutoHideEnabled(autoHide);
    }
}
