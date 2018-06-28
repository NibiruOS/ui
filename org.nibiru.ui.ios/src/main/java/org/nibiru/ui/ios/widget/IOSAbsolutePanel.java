package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.uikit.UIView;

public class IOSAbsolutePanel extends IOSContainer implements AbsolutePanel {
    @Inject
    public IOSAbsolutePanel() {
    }

    @Override
    public Position getPosition(Widget child) {
        final UIView view = (UIView) child.asNative();
        return new Position() {

            @Override
            public Position setY(int y) {
                CGRect frame = view.frame();
                view.setFrame(new CGRect(new CGPoint(frame.origin().x(), y), frame.size()));
                return this;
            }

            @Override
            public Position setX(int x) {
                CGRect frame = view.frame();
                view.setFrame(new CGRect(new CGPoint(x, frame.origin().y()), frame.size()));
                return this;
            }

            @Override
            public int getY() {
                return (int) view.frame().origin().y();
            }

            @Override
            public int getX() {
                return (int) view.frame().origin().x();
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

    @Override
    protected int getNativeHeight() {
        return 0;
    }

    @Override
    protected int getNativeWidth() {
        return 0;
    }
}
