package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Registration;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.html.HTMLElement;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListenerAdapter implements Registration {
    private final HTMLElement control;
    private final String event;
    private final EventListener<Event> listener;

    public ListenerAdapter(HTMLElement control,
                           String event,
                           EventListener<Event> listener) {
        this.control = checkNotNull(control);
        this.event = checkNotNull(event);
        this.listener = checkNotNull(listener);
        control.addEventListener(event, listener);
    }

    @Override
    public void remove() {
        control.removeEventListener(event, listener);
    }
}
