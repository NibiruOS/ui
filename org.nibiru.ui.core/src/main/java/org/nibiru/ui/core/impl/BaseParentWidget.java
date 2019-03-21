package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseParentWidget extends BaseWidget implements IsParent {
    private final Viewport viewport;
    private final Looper looper;
    private boolean isLayoutScheduled;
    private boolean isLayoutDirty;

    public BaseParentWidget(Viewport viewport,
                            Looper looper) {
        this.viewport = checkNotNull(viewport);
        this.looper = checkNotNull(looper);
    }

    @Override
    public void layout() {
        super.layout();
        isLayoutDirty = false;
    }

    /**
     * Method to request the measure and layout of the panel and all its children.
     * For the measure phase the MeasureSpec with the restrictions to its children should be passed.
     */
    @Override
    public void requestLayout() {
        if (getParent() != null) {
            getParent().requestLayout();
        } else {
            MeasureSpec widthSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getWidth()), getStyle().getWidth());
            MeasureSpec heightSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getHeight()), getStyle().getHeight());
            measure(widthSpec, heightSpec);
            layout();
        }
    }

    @Override
    public void scheduleLayout() {
        isLayoutDirty = true;
        if (getParent() != null) {
            getParent().scheduleLayout();
            isLayoutScheduled = false;
        } else if (!isLayoutScheduled) {
            isLayoutScheduled = true;
            looper.post(() -> {
                isLayoutScheduled = false;
                if (getParent() != null) {
                    getParent().scheduleLayout();
                } else {
                    if (isLayoutDirty) {
                        requestLayout();
                    }
                }
            });
        }
    }
}
