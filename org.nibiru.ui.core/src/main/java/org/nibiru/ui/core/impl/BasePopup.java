package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;

public abstract class BasePopup<T, N> extends BaseContentWidget<T, N> {
    protected BasePopup(T control,
                        Viewport viewport,
                        Looper looper) {
        super(control, viewport, looper);
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        if (getContent() != null) {
            measureChild(getContent(), widthSpec, heightSpec);
            updateSize(resolveWidth(getContent().getFullMeasuredWidth(), widthSpec),
                    resolveHeight(getContent().getFullMeasuredHeight(), heightSpec));
        }
    }
}
