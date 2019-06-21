package org.nibiru.ui.android.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import org.nibiru.ui.core.api.clipboard.Clipboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;
import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidClipboard implements Clipboard {
    private final ClipboardManager clipboardManager;

    @Inject
    public AndroidClipboard(@Nonnull Context context) {
        checkNotNull(context);
        this.clipboardManager = (ClipboardManager) context
                .getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @Nullable
    @Override
    public String getContent() {
        return clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN)
                ? clipboardManager.getPrimaryClip().getItemAt(0).getText().toString()
                : null;
    }

    @Override
    public void setContent(@Nullable String content) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("", content));
    }
}
