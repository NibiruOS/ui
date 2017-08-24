package org.nibiru.ui.ios.widget;

import com.google.common.base.Strings;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Style;

import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.foundation.NSString;
import apple.uikit.UIColor;
import apple.uikit.UIFont;
import apple.uikit.UIView;
import apple.uikit.enums.UITextAlignment;

import static org.nibiru.ui.core.impl.BaseWidget.colorToDouble;

class WidgetUtils {
    private WidgetUtils() {
    }

    static void applyStyle(UIView control, Style style) {
        control.setBackgroundColor(colorToNative(style.getBackgroundColor()));
    }

    static void setNativeSize(UIView control, int width, int height) {
        control.setFrame(new CGRect(control.frame().origin(), new CGSize(width, height)));
    }

    static UIColor colorToNative(Color color) {
        return UIColor.colorWithRedGreenBlueAlpha(colorToDouble(color.getRed()),
                colorToDouble(color.getGreen()),
                colorToDouble(color.getBlue()),
                colorToDouble(color.getAlpha()));
    }

    static CGSize sizeFromText(String text, UIFont font) {
        return NSString.stringWithString(Strings.isNullOrEmpty(text) ? "I" : text).sizeWithFont(font);
    }

    static long alignmentToTextAlignment(Alignment alignment) {
        switch (alignment) {
            case END:
                return UITextAlignment.Right;
            case CENTER:
                return UITextAlignment.Center;
            default:
                return UITextAlignment.Left;
        }
    }
}
