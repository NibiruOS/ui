package org.nibiru.ui.dotnet.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;

import javax.inject.Inject;

import cli.System.Windows.RoutedEventHandler;

public class DotNetButton
        extends DotNetValueWidget<cli.System.Windows.Controls.Button, String>
        implements Button {
    private static final int MARGIN = 10;

    @Inject
    public DotNetButton() {
        this(new cli.System.Windows.Controls.Button());
    }

    public DotNetButton(cli.System.Windows.Controls.Button button) {
        super(button);
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
        RoutedEventHandler handler =new RoutedEventHandler((s, e) -> {
            clickHandler.onClick();
        });
        control.add_Click(handler);
        return () -> control.remove_Click(handler);
    }
}
