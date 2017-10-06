package org.nibiru.ui.gwt.widget;

import com.google.common.base.Function;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.ui.core.impl.BaseControlWidget;

abstract class GwtWidget<T extends Widget> extends BaseControlWidget<T> {
    GwtWidget(T control) {
        super(control);
        getVisible().addObserver(
                () -> control.setVisible(Boolean.TRUE.equals(getVisible().get()))
        );
    }

    @Override
    public void applyStyle() {
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    protected int getNativeHeight() {
        return doWithClone(Element::getOffsetHeight);
    }

    @Override
    protected int getNativeWidth() {
        return doWithClone(Element::getOffsetWidth);
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        WidgetUtils.setNativeSize(control, measuredWidth, measuredHeight);
    }

    private <X> X doWithClone(Function<Element, X> callback) {
        Element clon = DOM.clone(control.getElement(), true);
        clon.getStyle().setPosition(Position.ABSOLUTE);
        clon.getStyle().clearPadding();
        clon.getStyle().clearWidth();
        clon.getStyle().clearHeight();
        Document.get().getBody().appendChild(clon);
        X returnValue = callback.apply(clon);
        clon.removeFromParent();
        return returnValue;
    }
}
