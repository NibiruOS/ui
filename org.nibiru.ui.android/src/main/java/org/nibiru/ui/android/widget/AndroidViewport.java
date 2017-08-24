package org.nibiru.ui.android.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.nibiru.ui.android.widget.WidgetUtils.pxToDp;

public class AndroidViewport implements Viewport {
    private final Context context;
    private final Display display;

    @Inject
    public AndroidViewport(Context context) {
        this.context = checkNotNull(context);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        this.display = wm.getDefaultDisplay();
    }

    @Override
    public int getWidth() {
        return pxToDp(getSize().x, context);
    }

    @Override
    public int getHeight() {
        return pxToDp(getSize().y, context);
    }

    private Point getSize() {
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}
