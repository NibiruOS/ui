package org.nibiru.ui.android.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidCanvas
        extends AndroidWidget<CanvasView>
        implements Canvas {
    private Path path;
    private Color strokeColor;
    private Color fillColor;
    private int lineWidth;

    @Inject
    public AndroidCanvas(Context context) {
        super(new CanvasView(context));
        beginPath();
    }

    @Override
    public Canvas arc(int x,
                      int y,
                      int radius,
                      double startAngle,
                      double endAngle) {
        int cX = dpToPx(x);
        int cY = dpToPx(y);

        float half = dpToPx(radius) / 2f;
        path.addArc(new RectF(cX - half,
                        cY - half,
                        cX + half,
                        cY + half),
                (float) Math.toDegrees(startAngle),
                (float) Math.toDegrees(endAngle - startAngle)
        );
        return this;
    }

    @Override
    public Canvas beginPath() {
        path = new Path();
        setStrokeStyle(Color.BLACK);
        setFillStyle(Color.BLACK);
        setLineWidth(1);
        return this;
    }

    @Override
    public Canvas clear() {
        control.clear();
        return this;
    }

    @Override
    public Canvas closePath() {
        path.close();
        return this;
    }

    @Override
    public Canvas fill() {
        control.addPathAndPaint(path,
                buildPaint(fillColor, Paint.Style.FILL, 1));
        return this;
    }

    @Override
    public Canvas lineTo(int x,
                         int y) {
        path.lineTo(dpToPx(x), dpToPx(y));
        return this;
    }

    @Override
    public Canvas moveTo(int x,
                         int y) {
        path.moveTo(dpToPx(x), dpToPx(y));
        return this;
    }

    @Override
    public Canvas rect(int x,
                       int y,
                       int width,
                       int height) {
        path.addRect(dpToPx(x),
                dpToPx(y),
                dpToPx(x + width),
                dpToPx(y + height),
                Path.Direction.CW);
        return this;
    }

    @Override
    public Canvas setFillStyle(Color color) {
        checkNotNull(color);
        fillColor = color;
        return this;
    }

    @Override
    public Canvas setLineWidth(int width) {
        lineWidth = width;
        return this;
    }

    @Override
    public Canvas setStrokeStyle(Color color) {
        checkNotNull(color);
        strokeColor = color;
        return this;
    }

    @Override
    public Canvas stroke() {
        control.addPathAndPaint(path,
                buildPaint(strokeColor, Paint.Style.STROKE, lineWidth));
        return this;
    }

    private Paint buildPaint(Color color,
                             Paint.Style style,
                             int strokeWidth) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(WidgetUtils.colorToNative(color));
        paint.setStyle(style);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(dpToPx(strokeWidth));
        return paint;
    }
}
