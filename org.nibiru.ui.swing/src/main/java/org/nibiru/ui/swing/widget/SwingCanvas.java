package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;
import javax.swing.JLabel;

import static com.google.common.base.Preconditions.checkNotNull;

// TODO: Implement canvas!
public class SwingCanvas
        extends SwingWidget<JLabel>
        implements Canvas {
    @Inject
    public SwingCanvas() {
        this(new JLabel());
    }

    public SwingCanvas(JLabel canvas) {
        super(canvas);
    }

    @Override
    public Canvas arc(int x,
                      int y,
                      int radius,
                      double startAngle,
                      double endAngle) {
//        control.addOperation((context) -> CoreGraphics.CGContextAddArc(context,
//                x,
//                y,
//                radius,
//                startAngle,
//                endAngle,
//                1));
        return this;
    }

    @Override
    public Canvas beginPath() {
//        control.addOperation(CoreGraphics::CGContextBeginPath);
        return this;
    }

    @Override
    public Canvas closePath() {
//        control.addOperation(CoreGraphics::CGContextClosePath);
        return this;
    }

    @Override
    public Canvas clear() {
//        control.clearOperations();
//        control.addOperation((context) -> CoreGraphics.CGContextClearRect(context, CoreGraphics.CGRectMake(0,
//                0,
//                control.frame().size().width(),
//                control.frame().size().height())));
        return this;
    }

    @Override
    public Canvas fill() {
//        control.addOperation(CoreGraphics::CGContextFillPath);
        return this;
    }

    @Override
    public Canvas lineTo(int x,
                         int y) {
//        control.addOperation((context) -> CoreGraphics.CGContextAddLineToPoint(context, x, y));
        return this;
    }

    @Override
    public Canvas moveTo(int x,
                         int y) {
//        control.addOperation((context) -> CoreGraphics.CGContextMoveToPoint(context, x, y));
        return this;
    }

    @Override
    public Canvas rect(int x,
                       int y,
                       int width,
                       int height) {
//        control.addOperation((context) -> CoreGraphics.CGContextAddRect(context,
//                CoreGraphics.CGRectMake(x, y, width, height)));
        return this;
    }

    @Override
    public Canvas setFillStyle(Color color) {
        checkNotNull(color);
//        control.addOperation((context) -> CoreGraphics.CGContextSetFillColorWithColor(context,
//                WidgetUtils.colorToNative(color).CGColor()));
        return this;
    }

    @Override
    public Canvas setLineWidth(int width) {
//        control.addOperation((context) -> CoreGraphics.CGContextSetLineWidth(context, width));
        return this;
    }

    @Override
    public Canvas setStrokeStyle(Color color) {
        checkNotNull(color);
//        control.addOperation((context) -> CoreGraphics.CGContextSetStrokeColorWithColor(context,
//                WidgetUtils.colorToNative(color).CGColor()));
        return this;
    }

    @Override
    public Canvas stroke() {
//        control.addOperation(CoreGraphics::CGContextStrokePath);
        return this;
    }
}
