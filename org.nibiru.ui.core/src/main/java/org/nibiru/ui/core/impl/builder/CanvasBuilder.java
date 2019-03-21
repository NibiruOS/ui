package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class CanvasBuilder extends BaseBuilder<Canvas>
        implements WidgetBuilder<Canvas, CanvasBuilder> {

    @Inject
    public CanvasBuilder(Canvas canvas) {
        super(canvas);
    }

    public CanvasBuilder arc(int x,
                             int y,
                             int radius,
                             double startAngle,
                             double endAngle) {
        object.arc(x, y, radius, startAngle, endAngle);
        return this;
    }

    public CanvasBuilder beginPath() {
        object.beginPath();
        return this;
    }

    public CanvasBuilder closePath() {
        object.closePath();
        return this;
    }

    // does this method make sense in the builder?
    public CanvasBuilder clear() {
        object.clear();
        return this;
    }

    public CanvasBuilder fill() {
        object.fill();
        return this;
    }

    public CanvasBuilder lineTo(int x, int y) {
        object.lineTo(x, y);
        return this;
    }

    public CanvasBuilder moveTo(int x, int y) {
        object.moveTo(x, y);
        return this;
    }

    public CanvasBuilder rect(int x,
                              int y,
                              int width,
                              int height) {
        object.rect(x, y, width, height);
        return this;
    }

    public CanvasBuilder setFillStyle(Color color) {
        checkNotNull(color);
        object.setFillStyle(color);
        return this;
    }

    public CanvasBuilder setFillStyle(Builder<? extends Color> color) {
        checkNotNull(color);
        return setFillStyle(color.build());
    }

    public CanvasBuilder setLineWidth(int width) {
        object.setLineWidth(width);
        return this;
    }

    public CanvasBuilder setStrokeStyle(Color color) {
        checkNotNull(color);
        object.setStrokeStyle(color);
        return this;
    }

    public CanvasBuilder setStrokeStyle(Builder<? extends Color> color) {
        checkNotNull(color);
        return setStrokeStyle(color.build());
    }

    public CanvasBuilder stroke() {
        object.stroke();
        return this;
    }
}
