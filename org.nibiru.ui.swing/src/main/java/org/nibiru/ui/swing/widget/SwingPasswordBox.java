package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.PasswordBox;

import javax.inject.Inject;
import javax.swing.JPasswordField;

public class SwingPasswordBox
        extends SwingTextBox
        implements PasswordBox {
    @Inject
    public SwingPasswordBox() {
        this(new JPasswordField());
    }

    public SwingPasswordBox(JPasswordField passwordField) {
        super(passwordField);
    }
}
