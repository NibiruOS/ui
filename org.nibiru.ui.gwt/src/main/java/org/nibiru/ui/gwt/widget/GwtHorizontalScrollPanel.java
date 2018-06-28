package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CustomScrollPanel;

import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class GwtHorizontalScrollPanel
        extends GwtScrollPanel
        implements HorizontalScrollPanel {
    @Inject
    public GwtHorizontalScrollPanel(Viewport viewport) {
        this(new CustomScrollPanel(), viewport);
    }

    public GwtHorizontalScrollPanel(CustomScrollPanel control,
                                    Viewport viewport) {
        super(control, viewport);
        control.addScrollHandler(event -> getScrollPosition().set(control.getHorizontalScrollPosition()));
        getScrollPosition().addObserver(() ->
                control.setHorizontalScrollPosition(getScrollPosition().get()));
    }
}
