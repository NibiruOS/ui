package org.nibiru.ui.core.impl;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaValue;
import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;


public abstract class BaseScrollPanel<T, N>
        extends BaseContentWidget<T, N>
        implements ScrollPanel {
    protected final Value<Integer> scrollPosition;

    protected BaseScrollPanel(T control,
                              Viewport viewport) {
        super(control, viewport);
        scrollPosition = JavaValue.of(0);
    }

    @Override
    public Value<Integer> getScrollPosition() {
        return scrollPosition;
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (getContent() != null) {
            measureChild(getContent(), MeasureSpec.exactly(getMeasuredWidth()), MeasureSpec.exactly(getMeasuredHeight()));
        }
    }
}
