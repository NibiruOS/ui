package org.nibiru.ui.gwt.clipboard;

import org.nibiru.ui.core.api.clipboard.Clipboard;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class GwtClipboard implements Clipboard {
    @Inject
    public GwtClipboard() {
    }

    @Nullable
    @Override
    public native String getContent() /*-{
        return $wnd.clipboardData.getData('text');
    }-*/;

    @Override
    public native void setContent(@Nullable String content) /*-{
        $wnd.clipboardData.setData('text', content);
    }-*/;
}
