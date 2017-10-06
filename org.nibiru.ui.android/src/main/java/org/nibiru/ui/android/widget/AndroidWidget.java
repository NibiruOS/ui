package org.nibiru.ui.android.widget;

import android.view.View;
import android.view.View.MeasureSpec;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.impl.BaseControlWidget;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class AndroidWidget<T extends View> extends BaseControlWidget<T> implements HasClickHandler {
    private Registration clickRegistration;

    AndroidWidget(T control) {
        super(control);
        getVisible().addObserver(() -> control.setVisibility(Boolean.TRUE.equals(getVisible().get())
                ? View.VISIBLE
                : View.GONE));
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
        WidgetUtils.setNativeSize(control, measuredWidth, measuredHeight);
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
        control.setOnClickListener(view -> clickHandler.onClick());
        clickRegistration = () -> control.setOnClickListener(null);
        return clickRegistration;
    }

    @Override
    public void applyStyle() {
        WidgetUtils.applyStyle(control, getStyle());
    }

    int dpToPx(int dp) {
        return WidgetUtils.dpToPx(dp, control.getContext());
    }

    int pxToDp(int px) {
        return WidgetUtils.pxToDp(px, control.getContext());
    }
}
