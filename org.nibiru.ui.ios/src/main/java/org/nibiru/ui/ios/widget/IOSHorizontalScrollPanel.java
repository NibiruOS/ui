package org.nibiru.ui.ios.widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import javax.inject.Inject;

import apple.coregraphics.struct.CGSize;
import apple.uikit.UIScrollView;
import apple.uikit.protocol.UIScrollViewDelegate;

import static apple.coregraphics.c.CoreGraphics.CGPointMake;

public class IOSHorizontalScrollPanel
        extends IOSScrollPanel
        implements HorizontalScrollPanel {
    @Inject
    public IOSHorizontalScrollPanel(Viewport viewport,
                                    Looper looper) {
        this(UIScrollView.alloc().init(), viewport, looper);
        control.setShowsVerticalScrollIndicator(false);
        control.setBounces(false);
    }

    public IOSHorizontalScrollPanel(UIScrollView control,
                                    Viewport viewport,
                                    Looper looper) {
        super(control, viewport, looper);
        // TODO: Should existing delegate (if any) be wrapped?
        control.setDelegate(new UIScrollViewDelegate() {
            @Override
            public void scrollViewDidEndDecelerating(UIScrollView scrollView) {
            }

            @Override
            public void scrollViewDidScroll(UIScrollView scrollView) {
                scrollPosition.set((int) scrollView.contentOffset().x());
            }
        });
        scrollPosition.addObserver(() ->
                control.setContentOffset(CGPointMake(scrollPosition.get(), 0)));
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (getContent() != null) {
            control.setContentSize(new CGSize(getContent().getFullMeasuredWidth(),
                    0));
        }
    }
}
