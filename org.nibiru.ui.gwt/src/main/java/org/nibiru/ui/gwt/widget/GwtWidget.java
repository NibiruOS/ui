package org.nibiru.ui.gwt.widget;

import com.google.common.base.Function;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.api.style.TextStyle;
import org.nibiru.ui.core.impl.BaseControlWidget;

import static com.google.gwt.dom.client.Style.TextTransform.UPPERCASE;
import static com.google.gwt.dom.client.Style.Unit.PX;
import static org.nibiru.ui.gwt.widget.WidgetUtils.alignmentToTextAlign;
import static org.nibiru.ui.gwt.widget.WidgetUtils.colorToNative;

abstract class GwtWidget<T extends Widget> extends BaseControlWidget<T> {
    private int fontSize = TextStyle.DEFAULT_FONT_SIZE;
    private boolean allCaps;

    GwtWidget(T control) {
        super(control);
        WidgetUtils.bindVisible(this, control);
    }

    @Override
    public void applyStyle() {
        Style style = getStyle();
        if (style instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) style;
            control.getElement()
                    .getStyle()
                    .setColor(colorToNative(textStyle.getTextColor()));
            control.getElement()
                    .getStyle()
                    .setTextAlign(alignmentToTextAlign(textStyle.getHorizontalTextAlignment()));
            int fontSize = textStyle.getFontSize();
            if (fontSize != TextStyle.DEFAULT_FONT_SIZE && fontSize != this.fontSize) {
                this.fontSize = fontSize;
                control.getElement()
                        .getStyle()
                        .setFontSize(fontSize, PX);
                scheduleLayout();
            }
            if (textStyle.getAllCaps() != allCaps) {
                allCaps = textStyle.getAllCaps();
                control.getElement()
                        .getStyle()
                        .setTextTransform(UPPERCASE);
                scheduleLayout();
            }
        }
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
