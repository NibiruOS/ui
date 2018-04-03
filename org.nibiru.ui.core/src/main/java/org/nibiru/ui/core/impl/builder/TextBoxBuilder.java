package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;

public class TextBoxBuilder
        extends BaseBuilder<TextBox>
        implements
        FocusableBuilder<TextBox, TextBoxBuilder>,
        HasEnabledBuilder<TextBox, TextBoxBuilder>,
        ValueWidgetBuilder<TextBox, String, TextBoxBuilder> {

    @Inject
    public TextBoxBuilder(TextBox textBox) {
        super(textBox);
    }
}