package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CustomScrollPanel;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class GwtHorizontalScrollPanel
        extends GwtScrollPanel
        implements HorizontalScrollPanel {
    @Inject
    public GwtHorizontalScrollPanel(Viewport viewport,
                                    Looper looper) {
        this(new CustomScrollPanel(), viewport, looper);
    }

    public GwtHorizontalScrollPanel(CustomScrollPanel control,
                                    Viewport viewport,
                                    Looper looper) {
        super(control, viewport, looper);
        control.addScrollHandler(event -> getScrollPosition().set(control.getHorizontalScrollPosition()));
        getScrollPosition().addObserver(() ->
                control.setHorizontalScrollPosition(getScrollPosition().get()));
    }
}
