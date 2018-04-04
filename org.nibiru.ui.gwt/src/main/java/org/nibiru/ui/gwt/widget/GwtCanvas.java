package org.nibiru.ui.gwt.widget;

import com.google.gwt.canvas.dom.client.Context2d;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;

public class GwtCanvas
        extends GwtWidget<com.google.gwt.canvas.client.Canvas>
        implements Canvas {

    private final Context2d context2d;

    @Inject
    public GwtCanvas() {
        this(com.google.gwt.canvas.client.Canvas.createIfSupported());
    }

    public GwtCanvas(com.google.gwt.canvas.client.Canvas canvas) {
        super(canvas);
        context2d = control.getContext2d();
    }

    @Override
    public Canvas arc(int x,
                      int y,
                      int radius,
                      double startAngle,
                      double endAngle) {
        context2d.arc(x, y, radius, startAngle, endAngle);
        return this;
    }

    @Override
    public Canvas beginPath() {
        context2d.beginPath();
        return this;
    }

    @Override
    public Canvas closePath() {
        context2d.closePath();
        return this;
    }

    @Override
    public Canvas clear() {
        context2d.clearRect(0,
                0,
                control.getOffsetWidth(),
                control.getOffsetHeight());
        return this;
    }

    @Override
    public Canvas fill() {
        context2d.fill();
        return this;
    }

    @Override
    public Canvas lineTo(int x,
                         int y) {
        context2d.lineTo(x, y);
        return this;
    }

    @Override
    public Canvas moveTo(int x,
                         int y) {
        context2d.moveTo(x, y);
        return this;
    }

    @Override
    public Canvas rect(int x,
                       int y,
                       int width,
                       int height) {
        context2d.rect(x, y, width, height);
        return this;
    }

    @Override
    public Canvas setFillStyle(Color color) {
        context2d.setFillStyle(color.asCss());
        return this;
    }

    @Override
    public Canvas setLineWidth(int width) {
        context2d.setLineWidth(width);
        return this;
    }

    @Override
    public Canvas setStrokeStyle(Color color) {
        context2d.setStrokeStyle(color.asCss());
        return this;
    }

    @Override
    public Canvas stroke() {
        context2d.stroke();
        return this;
    }
}
