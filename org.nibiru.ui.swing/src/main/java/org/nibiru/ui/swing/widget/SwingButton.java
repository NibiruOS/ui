package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.style.TextStyle;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;

import static org.nibiru.ui.swing.widget.WidgetUtils.alignmentToSwingConstant;
import static org.nibiru.ui.swing.widget.WidgetUtils.colorToNative;
import static org.nibiru.ui.swing.widget.WidgetUtils.sizeFromButton;

public class SwingButton
        extends SwingHasEnabledWidget<JButton, String>
        implements Button {

    private static final int MARGIN = 10;

    private Registration actionRegistration;

    @Inject
    public SwingButton() {
        this(new JButton());
    }

    public SwingButton(JButton button) {
        super(button);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) getStyle();
            control.setForeground(colorToNative(textStyle.getTextColor()));
            control.setHorizontalTextPosition(alignmentToSwingConstant(textStyle
                    .getHorizontalTextAlignment()));
            int fontSize = textStyle.getFontSize();
            if (fontSize != TextStyle.DEFAULT_FONT_SIZE && control.getFont().getSize() != fontSize) {
                control.setFont(control.getFont().deriveFont(fontSize));
                scheduleLayout();
            }
        }
    }

    @Override
    Value<String> buildValue() {
        return new TextValue(this) {
            @Override
            protected void setNativeText(String text) {
                control.setText(text);
            }
        };
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        if (actionRegistration != null) {
            actionRegistration.remove();
        }
        ActionListener actionListener = actionEvent -> clickHandler.onClick();
        control.addActionListener(actionListener);
        actionRegistration = () -> {
            control.removeActionListener(actionListener);
            actionRegistration = null;
        };
        return actionRegistration;
    }
}
