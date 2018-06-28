package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CustomScrollPanel;

import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class GwtVerticalScrollPanel
        extends GwtScrollPanel
        implements VerticalScrollPanel {
    @Inject
    public GwtVerticalScrollPanel(Viewport viewport) {
        this(new CustomScrollPanel(), viewport);
    }

    public GwtVerticalScrollPanel(CustomScrollPanel control,
                                  Viewport viewport) {
        super(control, viewport);
        control.addScrollHandler(event -> getScrollPosition().set(control.getVerticalScrollPosition()));
        getScrollPosition().addObserver(() ->
                control.setVerticalScrollPosition(getScrollPosition().get()));
    }
}
