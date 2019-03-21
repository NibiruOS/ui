package org.nibiru.ui.swing.widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import java.awt.Point;

import javax.inject.Inject;
import javax.swing.JScrollPane;

public class SwingVerticalScrollPanel
        extends SwingScrollPanel
        implements VerticalScrollPanel {
    @Inject
    public SwingVerticalScrollPanel(Viewport viewport,
                                    Looper looper) {
        this(new JScrollPane(), viewport, looper);
        control.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        control.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public SwingVerticalScrollPanel(JScrollPane control,
                                    Viewport viewport,
                                    Looper looper) {
        super(control, viewport, looper);
        // TODO: Should existing delegate (if any) be wrapped?
        control.getViewport().addChangeListener(changeEvent -> scrollPosition
                .set(control.getViewport().getViewPosition().y));
        scrollPosition.addObserver(() ->
                control.getViewport().setViewPosition(new Point(0, scrollPosition.get())));

    }
}
