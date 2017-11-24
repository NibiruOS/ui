package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.TextView;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

import static android.text.TextUtils.TruncateAt.END;
import static org.nibiru.ui.android.widget.WidgetUtils.alignmentToHorizontalGravity;
import static org.nibiru.ui.android.widget.WidgetUtils.colorToNative;

public class AndroidLabel
        extends AndroidHasEnabledWidget<TextView, String>
        implements Label {
    // TODO: Fix this "magic".
    private static int MAGIC_PADDING = 2;

    @Inject
    public AndroidLabel(Context context) {
        this(new TextView(context));
        control.setEllipsize(END);
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
            int fontSize = textStyle.getFontSize();
            if (fontSize > 0) {
                control.setTextSize(fontSize);
            }
            control.setAllCaps(textStyle.getAllCaps());
        }
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        super.setNativeSize(measuredWidth, measuredHeight);
        control.setMaxLines(measuredHeight / pxToDp(control.getLineHeight()));
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
