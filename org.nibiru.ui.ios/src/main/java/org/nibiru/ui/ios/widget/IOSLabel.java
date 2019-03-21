package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

import apple.coregraphics.struct.CGSize;
import apple.uikit.UIFont;
import apple.uikit.UILabel;
import apple.uikit.enums.UIControlState;

import static org.nibiru.ui.ios.widget.WidgetUtils.alignmentToTextAlignment;
import static org.nibiru.ui.ios.widget.WidgetUtils.colorToNative;
import static org.nibiru.ui.ios.widget.WidgetUtils.sizeFromText;

public class IOSLabel
        extends IOSHasEnabledWidget<UILabel, String>
        implements Label {

    @Inject
    public IOSLabel() {
        this(UILabel.alloc().init());
    }

    public IOSLabel(UILabel label) {
        super(label);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) getStyle();
            control.setTextColor(colorToNative(textStyle.getTextColor()));
            control.setTextAlignment(alignmentToTextAlignment(textStyle.getHorizontalTextAlignment()));
            int fontSize = textStyle.getFontSize();
            if (fontSize != TextStyle.DEFAULT_FONT_SIZE && control.font().pointSize() != fontSize) {
                control.setFont(UIFont.systemFontOfSize(fontSize));
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
    protected int getNativeHeight() {
        return (int) size().height();
    }

    @Override
    protected int getNativeWidth() {
        return (int) size().width();
    }

    private CGSize size() {
        return sizeFromText(control.text(), control.font());
    }
}
