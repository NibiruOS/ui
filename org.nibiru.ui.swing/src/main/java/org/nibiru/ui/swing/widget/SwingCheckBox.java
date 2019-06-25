package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.CheckBox;

import java.awt.event.ActionEvent;

import javax.inject.Inject;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;

public class SwingCheckBox
        extends SwingHasEnabledWidget<JCheckBox, Boolean>
        implements CheckBox {
    private static final int MARGIN = 5;

    private final Value<String> labelValue;

    @Inject
    public SwingCheckBox() {
        this(new JCheckBox());
    }

    public SwingCheckBox(JCheckBox checkBox) {
        super(checkBox);
        labelValue = new BaseValue<String>() {
            @Override
            public String get() {
                return control.getText();
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
        checkBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(() -> SwingCheckBox.this.getValue()
                        .notifyObservers());
            }
        });
    }

    @Override
    public Value<String> getTextLabel() {
        return labelValue;
    }

    @Override
    Value<Boolean> buildValue() {
        return new BaseValue<Boolean>() {
            @Override
            public Boolean get() {
                return control.isSelected();
            }

            @Override
            protected void setValue(Boolean value) {
                control.setSelected(Boolean.TRUE.equals(value));
            }

            @Override
            public Type<Boolean> getType() {
                return JavaType.BOOLEAN;
            }
        };
    }
}
