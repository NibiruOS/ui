package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CustomScrollPanel;
import com.google.gwt.user.client.ui.NativeHorizontalScrollbar;
import com.google.gwt.user.client.ui.NativeVerticalScrollbar;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaValue;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.impl.BaseContentWidget;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

public class GwtScrollPanel
        extends BaseContentWidget<CustomScrollPanel, Widget>
        implements VerticalScrollPanel, HorizontalScrollPanel {
    private final HorizontalScrollbar horizontalScrollbar;
    private final VerticalScrollbar verticalScrollbar;
    private final Value<Integer> scrollPosition;

    @Inject
    public GwtScrollPanel(Viewport viewport) {
        this(new CustomScrollPanel(), viewport);
    }

    public GwtScrollPanel(CustomScrollPanel control, Viewport viewport) {
        super(control, viewport);
        horizontalScrollbar = new HorizontalScrollbar();
        verticalScrollbar = new VerticalScrollbar();
        control.setHorizontalScrollbar(horizontalScrollbar, horizontalScrollbar.getNativeHeight());
        control.setVerticalScrollbar(verticalScrollbar, verticalScrollbar.getNativeWidth());
        WidgetUtils.bindVisible(this, control);
        scrollPosition = JavaValue.of(0);
        // TODO: Add listeners for scroll position
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (getContent() != null) {
            measureChild(getContent(),
                    MeasureSpec.exactly(getMeasuredWidth()),
                    MeasureSpec.exactly(getMeasuredHeight()));
            boolean measureHeightAgain = getContent().getMeasuredWidth() > getMeasuredWidth();
            boolean measureWidhtAgain = getContent().getMeasuredWidth() > getMeasuredWidth();
            if (measureHeightAgain || measureWidhtAgain) {
                measureChild(getContent(),
                        MeasureSpec.exactly(getMeasuredWidth() - (measureWidhtAgain ? verticalScrollbar.getNativeWidth() : 0)),
                        MeasureSpec.exactly(getMeasuredHeight() - (measureHeightAgain ? horizontalScrollbar.getNativeHeight() : 0)));
            }
        }
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    public Value<Integer> getScrollPosition() {
        return scrollPosition;
    }

    @Override
    protected void setNativeContent(com.google.gwt.user.client.ui.Widget nativeContent) {
        control.clear();
        control.add(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        // Using custom logic because WidgetUtils.setNativeSize() removes the scroll.
        control.setWidth(width + "px");
        control.setHeight(height + "px");
    }

    private static class HorizontalScrollbar extends NativeHorizontalScrollbar {
        @Override
        protected int getNativeHeight() {
            return super.getNativeHeight();
        }
    }

    private static class VerticalScrollbar extends NativeVerticalScrollbar {
        @Override
        protected int getNativeWidth() {
            return super.getNativeWidth();
        }
    }
}
