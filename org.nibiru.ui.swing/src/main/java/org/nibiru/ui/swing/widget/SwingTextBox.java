package org.nibiru.ui.swing.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SwingTextBox
        extends SwingHasEnabledWidget<JTextField, String>
        implements TextBox {
    @Inject
    public SwingTextBox() {
        this(new JTextField());
    }

    public SwingTextBox(final JTextField textField) {
        super(textField);
        control.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                notifyObservers();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                notifyObservers();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                notifyObservers();
            }

            private void notifyObservers() {
                SwingUtilities.invokeLater(() -> getValue().notifyObservers());
            }
        });
    }

    @Override
    public void applyStyle() {
        // Background color can't be applied to JTextField
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            @Override
            public String get() {
                return Strings.nullToEmpty(control.getText());
            }

            @Override
            protected void setValue(String value) {
                control.setText(value);
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }
        };
    }
}
