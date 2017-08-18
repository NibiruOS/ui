package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.impl.BaseControlWidget;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class AndroidWidget<T extends View> extends BaseControlWidget<T> implements HasClickHandler {
    private Registration clickRegistration;

    AndroidWidget(T control) {
        super(control);
    }

    @Override
    protected int getNativeHeight() {
        control.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        return pxToDp(control.getMeasuredHeight());
    }

    @Override
    protected int getNativeWidth() {
        control.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        return pxToDp(control.getMeasuredWidth());
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        LayoutParams params = getLayoutParams();
        params.width = dpToPx(measuredWidth);
        params.height = dpToPx(measuredHeight);
        control.setLayoutParams(params);
    }

    @Override
    public T asNative() {
        return control;
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        checkNotNull(clickHandler);
        if (clickRegistration != null) {
            clickRegistration.remove();
        }
        control.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickHandler.onClick();
            }
        });
        clickRegistration = new Registration() {
            @Override
            public void remove() {
                control.setOnClickListener(null);
            }
        };
        return clickRegistration;
    }

    @Override
    public void applyStyle() {
        applyStyle(control, getStyle());
    }

    static void applyStyle(View control, Style style) {
        control.setBackgroundColor(colorToNative(style.getBackgroundColor()));
    }

    int dpToPx(int dp) {
        return AndroidViewport.dpToPx(dp, control.getContext());
    }

    int pxToDp(int px) {
        return AndroidViewport.pxToDp(px, control.getContext());
    }

    private LayoutParams getLayoutParams() {
        LayoutParams params = control.getLayoutParams();
        return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    protected static int colorToNative(Color color) {
        return android.graphics.Color.argb(color.getAlpha(),
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    protected static int alignmentToHorizontalGravity(Alignment alignment) {
        switch (alignment) {
            case CENTER:
                return Gravity.CENTER_HORIZONTAL;
            case END:
                return Gravity.RIGHT;
            default:
                return Gravity.LEFT;
        }
    }
}
