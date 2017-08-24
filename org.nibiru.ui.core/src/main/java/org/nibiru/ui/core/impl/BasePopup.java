package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;

public abstract class BasePopup<T, N> extends BaseContentWidget<T, N> {
    protected BasePopup(T control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        if (getContent() != null) {
            measureChild(getContent(), widthSpec, heightSpec);
            updateSize(resolveWidth(getContent().getMeasuredWidth(), widthSpec),
                    resolveHeight(getContent().getMeasuredHeight(), heightSpec));
        } else {
            super.onMeasure(widthSpec, heightSpec);
        }
    }
}
