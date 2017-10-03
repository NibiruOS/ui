package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseWidget implements Widget {
    // Widget size after measuring phase
    private int measuredWidth;
    private int measuredHeight;

    private boolean needsMeasureAgain = false;

    private MeasureSpec mOldWidthMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);

    private MeasureSpec mOldHeightMeasureSpec = MeasureSpec.exactly(Integer.MIN_VALUE);

    private Style style = Style.DEFAULT;
    private IsParent parent;

    @Override
    public int getMeasuredHeight() {
        return measuredHeight;
    }

    @Override
    public int getMeasuredWidth() {
        return measuredWidth;
    }

    @Override
    public int getFullMeasuredHeight() {
        return style.getMarginTop() + measuredHeight + style.getMarginBottom();
    }

    @Override
    public int getFullMeasuredWidth() {
        return style.getMarginLeft() + measuredWidth + style.getMarginRight();
    }

    public final void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onMeasure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        updateSize(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
    }

    protected int resolveWidth(int size, MeasureSpec measureSpec) {
        return resolveSize(size, measureSpec, getStyle().getWidth());
    }

    protected int resolveHeight(int size, MeasureSpec measureSpec) {
        return resolveSize(size, measureSpec, getStyle().getHeight());
    }

    /**
     * This method resolves the final size for panels after measuring the children.
     * If parent had an exactly size, we use that one, if not we use the one calculated after measuring all its children.
     *
     * @param size        value calculated after measuring all children
     * @param measureSpec restrictions imposed to the widget
     * @return widget size
     */
    private int resolveSize(int size, MeasureSpec measureSpec, Size styleSize) {
        int result = size;
        switch (measureSpec.getType()) {
            case UNSPECIFIED:
                result = size;
                break;
            case AT_MOST:
                if (styleSize.equals(Size.MATCH_PARENT)) {
                    result = measureSpec.getValue();
                } else {
                    result = size;
                }
                break;
            case EXACTLY:
                result = measureSpec.getValue();
                break;
        }
        return result;
    }

    public static int getDefaultSize(int size, MeasureSpec measureSpec) {
        int result = size;

        switch (measureSpec.getType()) {
            case UNSPECIFIED:
                result = size;
                break;
            case AT_MOST:
            case EXACTLY:
                result = measureSpec.getValue();
                break;
        }
        return result;
    }

    protected void updateSize(int measuredWidth, int measuredHeight) {
        this.measuredWidth = measuredWidth;
        this.measuredHeight = measuredHeight;
    }

    @Override
    public void layout() {
        applyStyle();
        //TODO this is in case the children violates the parent size
        if (needsMeasureAgain) {
            onMeasure(mOldWidthMeasureSpec, mOldHeightMeasureSpec);
            needsMeasureAgain = false;
        }

        onLayout();
    }

    protected void onLayout() {
    }

    // Convenience method for perfroming common layout request operation
    // from different subcasses with different viewport references.
    public void requestLayout(Viewport viewport) {
        if (getParent() != null) {
            getParent().requestLayout();
        } else {
            MeasureSpec widthSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getWidth()), getStyle().getWidth());
            MeasureSpec heightSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getHeight()), getStyle().getHeight());
            measure(widthSpec, heightSpec);
            layout();
        }
    }

    protected void measureChild(Widget child, MeasureSpec parentWidthMeasureSpec,
                                       MeasureSpec parentHeightMeasureSpec) {
        MeasureSpec childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, child.getStyle().getWidth());
        MeasureSpec childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, child.getStyle().getHeight());

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    /**
     * This method propagates the restriction imposed to the widget to its children
     *
     * @param spec           restriction imposed to the parent widget
     * @param childDimension size of the child
     * @return
     */
    static MeasureSpec getChildMeasureSpec(MeasureSpec spec, Size childDimension) {
        int size = spec.getValue();

        int resultSize = 0;
        MeasureSpec.Type resultMode = null;

        switch (spec.getType()) {
            // Parent has imposed an exact size on us
            case EXACTLY:
                if (childDimension.getValue() >= 0) {
                    resultSize = childDimension.getValue();
                    resultMode = MeasureSpec.Type.EXACTLY;
                } else if (childDimension == Size.MATCH_PARENT) {
                    // Child wants to be our size. So be it.
                    resultSize = size;
                    resultMode = MeasureSpec.Type.EXACTLY;
                } else if (childDimension == Size.WRAP_CONTENT) {
                    // Child wants to determine its own size. It can't be bigger than us.
                    resultSize = size;
                    resultMode = MeasureSpec.Type.AT_MOST;
                }
                break;

            // Parent has imposed a maximum size on us
            case AT_MOST:
                if (childDimension.getValue() >= 0) {
                    // Child wants a specific size
                    resultSize = childDimension.getValue();
                    resultMode = MeasureSpec.Type.EXACTLY;
                } else if (childDimension == Size.MATCH_PARENT) {
                    // Child wants to be our size, but our size is not fixed. Constrain child to not be bigger than us.
                    resultSize = size;
                    resultMode = MeasureSpec.Type.AT_MOST;
                } else if (childDimension == Size.WRAP_CONTENT) {
                    // Child wants to determine its own size. It can't be bigger than us.
                    resultSize = size;
                    resultMode = MeasureSpec.Type.AT_MOST;
                }
                break;

            // Parent asked to see how big we want to be
            case UNSPECIFIED:
                if (childDimension.getValue() >= 0) {
                    // Child wants a specific size
                    resultSize = childDimension.getValue();
                    resultMode = MeasureSpec.Type.EXACTLY;
                } else if (childDimension == Size.MATCH_PARENT) {
                    // Child wants to be our size but we have to find out how big it should be
                    resultSize = 0;
                    resultMode = MeasureSpec.Type.UNSPECIFIED;
                } else if (childDimension == Size.WRAP_CONTENT) {
                    // Child wants to determine its own size but we have to find out how big it should be
                    resultSize = 0;
                    resultMode = MeasureSpec.Type.UNSPECIFIED;
                }
                break;
        }
        MeasureSpec mspec = null;
        switch (resultMode) {
            case AT_MOST:
                mspec = MeasureSpec.atMost(resultSize);
                break;
            case EXACTLY:
                mspec = MeasureSpec.exactly(resultSize);
                break;
            case UNSPECIFIED:
                mspec = MeasureSpec.UNSPECIFIED;
                break;
        }
        return mspec;
    }

    @Override
    public void setStyle(Style style) {
        this.style = checkNotNull(style);
    }

    @Override
    public Style getStyle() {
        return style;
    }

    @Override
    public IsParent getParent() {
        return parent;
    }

    @Override
    public void setParent(@Nullable IsParent parent) {
        this.parent = parent;
    }

    public static double colorToDouble(int color) {
        return color / 255d;
    }
}