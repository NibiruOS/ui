package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import java.awt.Rectangle;

import javax.inject.Inject;
import javax.swing.JComponent;

public class SwingAbsolutePanel extends SwingContainer implements AbsolutePanel {
    @Inject
    public SwingAbsolutePanel() {
        control.setLayout(null);
    }

    @Override
    public Position getPosition(Widget child) {
        final JComponent view = (JComponent) child.asNative();
        return new Position() {

            @Override
            public Position setY(int y) {
                Rectangle bounds = view.getBounds();
                view.setBounds(bounds.x, y, bounds.width, bounds.height);
                return this;
            }

            @Override
            public Position setX(int x) {
                Rectangle bounds = view.getBounds();
                view.setBounds(x, bounds.y, bounds.width, bounds.height);
                return this;
            }

            @Override
            public int getY() {
                return view.getBounds().y;
            }

            @Override
            public int getX() {
                return view.getBounds().x;
            }
        };
    }

    @Override
    protected void onMeasure(MeasureSpec widthMeasureSpec,
                             MeasureSpec heightMeasureSpec) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (Widget child : getVisibleChildren()) {
            measureChild(child,
                    MeasureSpec.UNSPECIFIED,
                    MeasureSpec.UNSPECIFIED);

            int newWidth = getPosition(child).getX()
                    + child.getFullMeasuredWidth();
            if (newWidth > maxWidth) {
                maxWidth = newWidth;
            }

            int newHeight = getPosition(child).getY()
                    + child.getFullMeasuredHeight();
            if (newHeight > maxHeight) {
                maxHeight = newHeight;
            }
        }
        updateSize(resolveWidth(maxWidth, widthMeasureSpec),
                resolveHeight(maxHeight, heightMeasureSpec));
    }
}
