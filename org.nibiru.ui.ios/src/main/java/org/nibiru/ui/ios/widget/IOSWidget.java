package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.impl.BaseControlWidget;

import apple.uikit.UIView;

abstract class IOSWidget<T extends UIView> extends BaseControlWidget<T> {
    IOSWidget(T control) {
        super(control);
    }

    @Override
    public void applyStyle() {
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    public void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }

    public Registration setClickHandler(ClickHandler clickHandler) {
        return TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(control, clickHandler);
    }
}
