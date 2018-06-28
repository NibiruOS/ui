package org.nibiru.ui.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

class CanvasView extends View {
    private List<PathAndPaint> paths;

    CanvasView(Context context) {
        super(context);
        paths = Lists.newArrayList();
    }

    void addPathAndPaint(Path path, Paint paint) {
        checkNotNull(path);
        checkNotNull(paint);
        paths.add(new PathAndPaint(path, paint));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (PathAndPaint pathAndPaint : paths) {
            canvas.drawPath(pathAndPaint.path, pathAndPaint.paint);
        }
    }

    void clear() {
        paths.clear();
    }

    private static class PathAndPaint {
        private final Path path;
        private final Paint paint;

        private PathAndPaint(Path path, Paint paint) {
            this.path = path;
            this.paint = paint;
        }
    }
}
