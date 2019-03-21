package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CustomScrollPanel;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class GwtVerticalScrollPanel
        extends GwtScrollPanel
        implements VerticalScrollPanel {
    @Inject
    public GwtVerticalScrollPanel(Viewport viewport,
                                  Looper looper) {
        this(new CustomScrollPanel(), viewport, looper);
    }

    public GwtVerticalScrollPanel(CustomScrollPanel control,
                                  Viewport viewport,
                                  Looper looper) {
        super(control, viewport, looper);
        control.addScrollHandler(event -> getScrollPosition().set(control.getVerticalScrollPosition()));
        getScrollPosition().addObserver(() ->
                control.setVerticalScrollPosition(getScrollPosition().get()));
    }
}
