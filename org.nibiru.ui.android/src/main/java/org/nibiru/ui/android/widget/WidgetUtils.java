package org.nibiru.ui.android.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Orientation;
import org.nibiru.ui.core.api.style.Style;

class WidgetUtils {
    private WidgetUtils() {
    }

    static void applyStyle(View control, Style style) {
        control.setBackgroundColor(colorToNative(style.getBackgroundColor()));
    }

    static void setNativeSize(View control, int width, int height) {
        LayoutParams params = getLayoutParams(control);
        params.width = dpToPx(width, control.getContext());
        params.height = dpToPx(height, control.getContext());
        control.setLayoutParams(params);
    }

    private static LayoutParams getLayoutParams(View control) {
        LayoutParams params = control.getLayoutParams();
        return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    static int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((px / displayMetrics.density) + 0.5);
    }

    static void bindVisible(Widget widget, View control) {
        widget.getVisible().addObserver(() -> control.setVisibility(Boolean.TRUE.equals(widget.getVisible().get())
                ? View.VISIBLE
                : View.GONE));
    }

    static int colorToNative(Color color) {
        return android.graphics.Color.argb(color.getAlpha(),
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    static int alignmentToHorizontalGravity(Alignment alignment) {
        switch (alignment) {
            case CENTER:
                return Gravity.CENTER_HORIZONTAL;
            case END:
                return Gravity.RIGHT;
            default:
                return Gravity.LEFT;
        }
    }

    static int orientationToNative(Orientation orientation) {
        return orientation == Orientation.VERTICAL
                ? LinearLayout.VERTICAL
                : LinearLayout.HORIZONTAL;
    }
}
