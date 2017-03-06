package org.nibiru.ui.teavm.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Checkbox;
import org.teavm.jso.dom.html.HTMLElement;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class TeaVmCheckbox extends TeaVmValueWidget<HTMLElement, Boolean> implements Checkbox {
    private Value<String> labelText;

    @Inject
    public TeaVmCheckbox() {
        this(createElement("div"));
    }

    public TeaVmCheckbox(HTMLElement checkbox) {
        super(checkbox);
    }

    @Override
    Value<Boolean> buildValue() {
        return new BaseValue<Boolean>() {
            @Nullable
            @Override
            public Boolean get() {
                return false;
            }


            @Override
            protected void setValue(@Nullable Boolean aBoolean) {

            }

            @Override
            public Type<Boolean> getType() {
                return JavaType.BOOLEAN;
            }
        };
    }

    @Override
    public Value<String> getTextLabel() {
        if (labelText == null) {
            labelText = new HtmlValueAdapter(control);
        }
        return labelText;
    }
}
