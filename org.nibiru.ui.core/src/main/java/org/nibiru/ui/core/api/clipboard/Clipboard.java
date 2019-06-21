package org.nibiru.ui.core.api.clipboard;

import javax.annotation.Nullable;

public interface Clipboard {
    @Nullable
    String getContent();

    void setContent(@Nullable String content);
}
