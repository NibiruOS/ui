package org.nibiru.ui.dotnet.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Label;

import javax.inject.Inject;

public class DotNetLabel extends DotNetValueWidget<cli.System.Windows.Controls.Label, String> implements Label {
    @Inject
    public DotNetLabel() {
        this(new cli.System.Windows.Controls.Label());
    }

    public DotNetLabel(cli.System.Windows.Controls.Label label) {
        super(label);
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            private String text;

            @Override
            public String get() {
                return Strings.nullToEmpty(text);
            }

            @Override
            protected void setValue(String value) {
                control.AddText(value);
                text = value;
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }
        };
    }

    @Override
    protected int getNativeHeight() {
        return 25;
    }

    @Override
    protected int getNativeWidth() {
        return Strings.nullToEmpty(getValue().get()).length() * 8;
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        return () -> {
        };
    }
}
