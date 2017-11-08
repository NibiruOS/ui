package org.nibiru.ui.gwt.widget;


import com.google.common.collect.Maps;
import com.google.gwt.user.client.ui.AbsolutePanel;

import org.nibiru.ui.core.api.Widget;

import java.util.Map;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class GwtAbsolutePanel extends GwtContainer<AbsolutePanel> implements org.nibiru.ui.core.api.AbsolutePanel {
    private static Map<Widget, Position> positions;

    @Inject
    public GwtAbsolutePanel() {
        this(new AbsolutePanel());
    }

    public GwtAbsolutePanel(AbsolutePanel panel) {
        super(panel);
        positions = Maps.newHashMap();
    }

    @Override
    public Position getPosition(Widget child) {
        checkNotNull(child);
        return positions.computeIfAbsent(child,
                (key) -> new GwtPosition(key));
    }

    @Override
    public void requestLayout() {
    }

    // This class caches X and Y coordinates because getWidgetLeft()
    // and getWidgetTop() return 0 if the widget is hiden.
    private class GwtPosition implements Position {
        private final com.google.gwt.user.client.ui.Widget gwtWidget;
        private int x;
        private int y;

        private GwtPosition(Widget child) {
            this.gwtWidget = (com.google.gwt.user.client.ui.Widget) child.asNative();
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public Position setX(int x) {
            this.x = x;
            control.setWidgetPosition(gwtWidget, x, getY());
            return this;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public Position setY(int y) {
            this.y = y;
            control.setWidgetPosition(gwtWidget, getX(), y);
            return this;
        }
    }
}
