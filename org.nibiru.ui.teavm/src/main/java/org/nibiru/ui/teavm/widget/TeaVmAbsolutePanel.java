package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;
import org.teavm.jso.dom.html.HTMLElement;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TeaVmAbsolutePanel extends TeaVmContainer implements AbsolutePanel {
    @Inject
    public TeaVmAbsolutePanel() {
        this(createElement("div"));
    }

    public TeaVmAbsolutePanel(HTMLElement panel) {
        super(panel);
    }

    @Override
    public Position getPosition(Widget child) {
        checkNotNull(child);
        final HTMLElement childElement = (HTMLElement) child.asNative();
        childElement.getStyle().setProperty("position", "absolute");
        return new Position() {

            @Override
            public int getX() {
                return childElement.getAbsoluteLeft() - control.getAbsoluteLeft();
            }

            @Override
            public Position setX(int x) {
                childElement.getStyle().setProperty("left", x + "px");
                return this;
            }

            @Override
            public int getY() {
                return childElement.getAbsoluteTop() - control.getAbsoluteTop();
            }

            @Override
            public Position setY(int y) {
                childElement.getStyle().setProperty("top", y + "px");
                return this;
            }
        };
    }

    @Override
    public void requestLayout() {
    }
}
