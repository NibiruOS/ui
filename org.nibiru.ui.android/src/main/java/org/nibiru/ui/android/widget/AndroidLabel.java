package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.TextView;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

public class AndroidLabel extends AndroidValueWidget<TextView, String> implements Label {
    // TODO: Fix this "magic".
    private static int MAGIC_PADDING = 2;

    @Inject
    public AndroidLabel(Context context) {
        this(new TextView(context));
    }

    public AndroidLabel(TextView textView) {
        super(textView);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) getStyle();
            control.setTextColor(colorToNative(textStyle.getTextColor()));
            control.setGravity(alignmentToHorizontalGravity(textStyle.getHorizontalTextAlignment()));
        }
    }

    @Override
    Value<String> buildValue() {
        return new LabelValue(control);
    }

    @Override
    protected int getNativeWidth() {
        return super.getNativeWidth() + MAGIC_PADDING;
    }
}
