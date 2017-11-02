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
        if (style instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) style;
            control.getElement()
                    .getStyle()
                    .setColor(colorToNative(textStyle.getTextColor()));
            control.getElement()
                    .getStyle()
                    .setTextAlign(alignmentToTextAlign(textStyle.getHorizontalTextAlignment()));
            int fontSize = textStyle.getFontSize();
            if (fontSize > 0) {
                control.getElement()
                        .getStyle()
                        .setFontSize(fontSize, com.google.gwt.dom.client.Style.Unit.PX);
            }
            if (textStyle.getAllCaps()) {
                control.getElement()
                        .getStyle()
                        .setTextTransform(com.google.gwt.dom.client.Style.TextTransform.UPPERCASE);
            }
        }
    }

    static void setNativeSize(Widget control, int width, int height) {
        control.setWidth(width + "px");
        control.setHeight(height + "px");
        control.getElement().getStyle().setOverflow(com.google.gwt.dom.client.Style.Overflow.HIDDEN);
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
