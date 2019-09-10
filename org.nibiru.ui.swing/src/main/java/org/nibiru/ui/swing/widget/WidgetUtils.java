package org.nibiru.ui.swing.widget;

import com.google.common.base.Strings;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Orientation;
import org.nibiru.ui.core.api.style.Style;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

class WidgetUtils {
    private WidgetUtils() {
    }

    static void applyStyle(JComponent control, Style style) {
        control.setOpaque(true);
        control.setBackground(colorToNative(style.getBackgroundColor()));
    }

    static void setNativeSize(JComponent control, int width, int height) {
        control.setSize(width, height);
    }

    static java.awt.Color colorToNative(Color color) {
        // FIXME: Alpha channel seems to make UI rendering fail - ignoring it.
        return new java.awt.Color(color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    static Dimension sizeFromButton(AbstractButton button) {
        return sizeFromText(button.getGraphics(), button.getText(), button.getFont());
    }

    static Dimension sizeFromText(Graphics graphics,
                                  String text,
                                  Font font) {
        FontMetrics metrics = graphics.getFontMetrics(font);
        int hgt = metrics.getHeight();
        int adv = metrics.stringWidth(Strings.isNullOrEmpty(text) ? "I" : text);
        return new Dimension(adv, hgt);
    }

    static void bindVisible(Widget widget, JComponent control) {
        widget.getVisible().addObserver(() -> control
                .setVisible(Boolean.TRUE.equals(widget.getVisible().get())));
    }

    static int alignmentToSwingConstant(Alignment alignment) {
        switch (alignment) {
            case END:
                return SwingConstants.RIGHT;
            case CENTER:
                return SwingConstants.CENTER;
            default:
                return SwingConstants.LEFT;
        }
    }

    static int orientationToNative(Orientation orientation) {
        return orientation == Orientation.VERTICAL
                ? BoxLayout.Y_AXIS
                : BoxLayout.X_AXIS;

    }
}
