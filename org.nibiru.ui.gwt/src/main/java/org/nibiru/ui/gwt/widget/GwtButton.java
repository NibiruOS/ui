package org.nibiru.ui.gwt.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Button;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.gwt.resource.Resources;

import javax.inject.Inject;

public class GwtButton
        extends GwtClickableValueWidget<Button, String>
        implements org.nibiru.ui.core.api.Button, GwtFocusable<Button> {

    @Inject
    public GwtButton(Resources resources) {
        this(new Button());
        resources.css().ensureInjected();
        control.addStyleName(resources.css().button());
    }

    public GwtButton(Button button) {
        super(button);
        getEnabled().addObserver(() -> this.control.setEnabled(getEnabled().get()));
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        // Button text is always centered, to match Android behavior
        control.getElement()
                .getStyle()
                .setTextAlign(Style.TextAlign.CENTER);
    }

    @Override
    Value<String> buildValue() {
        return new HasTextAdapter(control);
    }
}
