package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.Widget;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.api.style.TextStyle;

import static org.nibiru.ui.core.impl.BaseWidget.colorToDouble;

class WidgetUtils {
    private WidgetUtils() {
    }

    static void applyStyle(Widget control, Style style) {
        control.getElement()
                .getStyle()
                .setBackgroundColor(colorToNative(style.getBackgroundColor()));
    }

    static void setNativeSize(Widget control, int width, int height) {
        control.setWidth(width + "px");
        control.setHeight(height + "px");
        control.getElement().getStyle().setOverflow(com.google.gwt.dom.client.Style.Overflow.HIDDEN);
    }

    static void bindVisible(org.nibiru.ui.core.api.Widget widget, Widget control) {
        widget.getVisible().addObserver(() -> control
                .setVisible(Boolean.TRUE.equals(widget.getVisible().get())));
    }

    static String colorToNative(Color color) {
        return "rgba("
                + color.getRed() + ","
                + color.getGreen() + ","
                + color.getBlue() + ","
                + colorToDouble(color.getAlpha()) + ")";
    }

    static com.google.gwt.dom.client.Style.TextAlign alignmentToTextAlign(Alignment alignment) {
        switch (alignment) {
            case END:
                return com.google.gwt.dom.client.Style.TextAlign.RIGHT;
            case CENTER:
                return com.google.gwt.dom.client.Style.TextAlign.CENTER;
            default:
                return com.google.gwt.dom.client.Style.TextAlign.LEFT;
        }
    }
}
