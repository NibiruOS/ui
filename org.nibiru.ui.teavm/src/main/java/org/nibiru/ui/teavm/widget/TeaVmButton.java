package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Button;
import org.teavm.jso.dom.html.HTMLButtonElement;

import javax.inject.Inject;

public class TeaVmButton extends TeaVmValueWidget<HTMLButtonElement, String>
        implements Button {
    @Inject
    public TeaVmButton() {
        this(createElement("button"));
    }

    public TeaVmButton(HTMLButtonElement button) {
        super(button);
    }

    @Override
    Value<String> buildValue() {
        return new HtmlValueAdapter(control);
    }
}
