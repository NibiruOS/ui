package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.PasswordBox;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class PasswordBoxBuilder
        extends BaseBuilder<PasswordBox>
        implements
        FocusableBuilder<PasswordBox, PasswordBoxBuilder>,
        HasEnabledBuilder<PasswordBox, PasswordBoxBuilder>,
        ValueWidgetBuilder<PasswordBox, String, PasswordBoxBuilder> {
    @Inject
    public PasswordBoxBuilder(PasswordBox passwordBox) {
        super(passwordBox);
    }

    public PasswordBoxBuilder enabled(boolean enabled) {
        object.getEnabled().set(enabled);
        return this;
    }

    public PasswordBox build(@Nullable String text) {
        return value(text).build();
    }
}