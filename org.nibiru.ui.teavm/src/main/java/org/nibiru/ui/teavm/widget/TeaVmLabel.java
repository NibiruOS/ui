package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;
import org.teavm.jso.dom.html.HTMLHtmlElement;

import javax.inject.Inject;


public class TeaVmLabel extends TeaVmValueWidget<HTMLHtmlElement, String> implements Label {
    @Inject
    public TeaVmLabel() {
        this(createElement("div"));
    }

    public TeaVmLabel(HTMLHtmlElement label) {
        super(label);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) getStyle();
            control.getStyle()
                    .setProperty("color", colorToNative(textStyle.getTextColor()));
        }
    }

    @Override
    Value<String> buildValue() {
        return new HtmlValueAdapter(control);
    }
}
