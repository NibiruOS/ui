package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import javax.inject.Inject;

public class AndroidAbsolutePanel extends AndroidContainer<RelativeLayout> implements AbsolutePanel {
    @Inject
    public AndroidAbsolutePanel(Context context) {
        this(new RelativeLayout(context));
    }

    public AndroidAbsolutePanel(RelativeLayout control) {
        super(control);
    }

    @Override
    public Position getPosition(Widget child) {
        View childView = (View) child.asNative();
        return new Position() {

            @Override
            public int getX() {
                return pxToDp(getLayoutParams(childView).leftMargin);
            }

            @Override
            public Position setX(int x) {
                LayoutParams params = getLayoutParams(childView);
                params.leftMargin = dpToPx(x);
                childView.setLayoutParams(params);
                return this;
            }

            @Override
            public int getY() {
                return pxToDp(getLayoutParams(childView).topMargin);
            }

            @Override
            public Position setY(int y) {
                LayoutParams params = getLayoutParams(childView);
                params.topMargin = dpToPx(y);
                childView.setLayoutParams(params);
                return this;
            }

        };
    }

    private LayoutParams getLayoutParams(View view) {
        LayoutParams params = (LayoutParams) view.getLayoutParams();
        return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void requestLayout() {
    }
}
