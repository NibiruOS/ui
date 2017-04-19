package org.nibiru.ui.android.widget;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidViewport implements Viewport {
    static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    static int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((px / displayMetrics.density) + 0.5);
    }

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
