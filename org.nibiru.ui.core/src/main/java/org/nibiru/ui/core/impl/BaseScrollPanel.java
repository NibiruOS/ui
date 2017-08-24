package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;


public abstract class BaseScrollPanel<T, N> extends BaseContentWidget<T, N> {
    protected BaseScrollPanel(T control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (getContent() != null) {
            measureChild(getContent(), MeasureSpec.exactly(getMeasuredWidth()), MeasureSpec.exactly(getMeasuredHeight()));
        }
    }
}
