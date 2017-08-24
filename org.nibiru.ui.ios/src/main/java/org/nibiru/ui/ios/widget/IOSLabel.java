package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

import apple.coregraphics.struct.CGSize;
import apple.uikit.UILabel;

import static org.nibiru.ui.ios.widget.WidgetUtils.alignmentToTextAlignment;
import static org.nibiru.ui.ios.widget.WidgetUtils.colorToNative;
import static org.nibiru.ui.ios.widget.WidgetUtils.sizeFromText;

public class IOSLabel extends IOSValueWidget<UILabel, String> implements Label {
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
        }
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            @Override
            public String get() {
                return control.text();
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
