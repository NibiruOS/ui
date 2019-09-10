package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.inject.Inject;
import javax.swing.JLabel;

import static org.nibiru.ui.swing.widget.WidgetUtils.alignmentToSwingConstant;
import static org.nibiru.ui.swing.widget.WidgetUtils.colorToNative;

public class SwingLabel
        extends SwingHasEnabledWidget<JLabel, String>
        implements Label {
    private Registration onClickRegistration;

    @Inject
    public SwingLabel() {
        this(new JLabel());
    }

    public SwingLabel(JLabel label) {
        super(label);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) getStyle();
            control.setForeground(colorToNative(textStyle.getTextColor()));
            control.setHorizontalAlignment(alignmentToSwingConstant(textStyle.getHorizontalTextAlignment()));
            int fontSize = textStyle.getFontSize();
            if (fontSize != TextStyle.DEFAULT_FONT_SIZE && control.getFont().getSize() != fontSize) {
                control.setFont(control.getFont().deriveFont((float) fontSize));
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
        if (onClickRegistration != null) {
            onClickRegistration.remove();
        }
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                clickHandler.onClick();
            }
        };
        control.addMouseListener(listener);
        onClickRegistration = () -> control.removeMouseListener(listener);
        return onClickRegistration;
    }
}
