package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.teavm.jso.dom.html.HTMLElement;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class HtmlValueAdapter extends BaseValue<String> {
    private final HTMLElement control;
    private String value;

    public HtmlValueAdapter(HTMLElement control) {
        this.control = checkNotNull(control);
    }


    @Override
    protected void setValue(@Nullable String value) {
        control.setInnerHTML(value);
        this.value = value;
    }

    @Nullable
    @Override
    public String get() {
        // TODO: getInnerHTML returns int!!!
        return value;
    }

    @Override
    public Type<String> getType() {
        return JavaType.STRING;
    }
}
