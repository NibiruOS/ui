package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.teavm.jso.dom.html.HTMLInputElement;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class InputValueAdapter extends BaseValue<String> {
    private final HTMLInputElement control;

    public InputValueAdapter(HTMLInputElement control) {
        this.control = checkNotNull(control);
    }

    @Override
    protected void setValue(@Nullable String value) {
        control.setValue(value);
    }

    @Nullable
    @Override
    public String get() {
        return control.getValue();
    }

    @Override
    public Type<String> getType() {
        return JavaType.STRING;
    }
}