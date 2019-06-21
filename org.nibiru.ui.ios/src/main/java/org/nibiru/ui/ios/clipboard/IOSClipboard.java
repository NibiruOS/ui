package org.nibiru.ui.ios.clipboard;

import org.nibiru.ui.core.api.clipboard.Clipboard;

import javax.annotation.Nullable;
import javax.inject.Inject;

import apple.uikit.UIPasteboard;

public class IOSClipboard implements Clipboard {
    private final UIPasteboard uiPasteboard;

    @Inject
    public IOSClipboard() {
        this.uiPasteboard = UIPasteboard.generalPasteboard();
    }

    @Nullable
    @Override
    public String getContent() {
        return uiPasteboard.string();
    }

    @Override
    public void setContent(@Nullable String content) {
        uiPasteboard.setString(content);
    }
}
