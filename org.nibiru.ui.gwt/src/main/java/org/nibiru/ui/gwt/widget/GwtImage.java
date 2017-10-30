package org.nibiru.ui.gwt.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.user.client.ui.Image;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class GwtImage extends GwtClickableValueWidget<Image, String> implements org.nibiru.ui.core.api.Image {
    private boolean dirty;

    @Inject
    public GwtImage() {
        this(new Image());
        control.addLoadHandler((LoadEvent event) -> {
            if (dirty) {
                scheduleLayout();
            }
        });
    }

    public GwtImage(Image control) {
        super(control);
    }

    @Override
    public void setBinaryContent(Format format, byte[] content) {
        checkNotNull(format);
        checkNotNull(content);
        setBase64Content(format, atob(new String(content)));
    }

    @Override
    public void setBase64Content(Format format, String content) {
        checkNotNull(format);
        checkNotNull(content);
        control.setUrl("data:image/"
                + format.toString().toLowerCase()
                + ";base64,"
                + content);
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        super.setNativeSize(measuredWidth, measuredHeight);
        dirty = (measuredWidth == 0 && measuredHeight == 0);
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            @Override
            public String get() {
                String url = control.getUrl();
                String prefix = GWT.getModuleBaseURL();
                return url != null && url.startsWith(prefix) ? url.substring(prefix.length()) : url;
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }

            @Override
            protected void setValue(String value) {
                control.setUrl(GWT.getModuleBaseURL() + checkNotNull(value));
            }
        };
    }

    private native String atob(String data) /*-{
        return atob(data);
    }-*/;
}
