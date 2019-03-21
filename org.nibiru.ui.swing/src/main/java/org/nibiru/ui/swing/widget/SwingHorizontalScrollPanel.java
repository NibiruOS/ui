package org.nibiru.ui.swing.widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import java.awt.Point;

import javax.inject.Inject;
import javax.swing.JScrollPane;

public class SwingHorizontalScrollPanel
        extends SwingScrollPanel
        implements HorizontalScrollPanel {
    @Inject
    public SwingHorizontalScrollPanel(Viewport viewport,
                                      Looper looper) {
        this(new JScrollPane(), viewport, looper);
        control.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        control.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    }

    public SwingHorizontalScrollPanel(JScrollPane control,
                                      Viewport viewport,
                                      Looper looper) {
        super(control, viewport, looper);
        // TODO: Should existing delegate (if any) be wrapped?
        control.getViewport().addChangeListener(changeEvent -> scrollPosition
                .set(control.getViewport().getViewPosition().x));
        scrollPosition.addObserver(() ->
                control.getViewport().setViewPosition(new Point(scrollPosition.get(), 0)));
    }
}
