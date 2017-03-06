package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.TextBox;
import org.teavm.jso.dom.html.HTMLInputElement;

import javax.inject.Inject;

public class TeaVmTextBox extends TeaVmValueWidget<HTMLInputElement, String>
        implements TextBox {
    @Inject
    public TeaVmTextBox() {
        this(createElement("input"));
    }

    public TeaVmTextBox(HTMLInputElement textBox) {
        super(textBox);
    }

    @Override
    Value<String> buildValue() {
        return new InputValueAdapter(control);
    }
}
