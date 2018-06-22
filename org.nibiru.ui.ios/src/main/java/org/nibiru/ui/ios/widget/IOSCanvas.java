package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;

import apple.uikit.UIView;

// TODO: Implement iOS canvas!
public class IOSCanvas
        extends IOSWidget<UIView>
        implements Canvas {

    @Inject
    public IOSCanvas() {
        this(UIView.alloc().init());
    }

    public IOSCanvas(UIView canvas) {
        super(canvas);
    }

    @Override
    public Canvas arc(int x,
                      int y,
                      int radius,
                      double startAngle,
                      double endAngle) {
        return this;
    }

    @Override
    public Canvas beginPath() {
        return this;
    }

    @Override
    public Canvas closePath() {
        return this;
    }

    @Override
    public Canvas clear() {
        return this;
    }

    @Override
    public Canvas fill() {
        return this;
    }

    @Override
    public Canvas lineTo(int x,
                         int y) {
        return this;
    }

    @Override
    public Canvas moveTo(int x,
                         int y) {
        return this;
    }

    @Override
    public Canvas rect(int x,
                       int y,
                       int width,
                       int height) {
        return this;
    }

    @Override
    public Canvas setFillStyle(Color color) {
        return this;
    }

    @Override
    public Canvas setLineWidth(int width) {
        return this;
    }

    @Override
    public Canvas setStrokeStyle(Color color) {
        return this;
    }

    @Override
    public Canvas stroke() {
        return this;
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
