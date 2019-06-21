package org.nibiru.ui.swing.clipboard;

import org.nibiru.ui.core.api.clipboard.Clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class SwingClipboard implements Clipboard {
    private final java.awt.datatransfer.Clipboard clipboard;

    @Inject
    public SwingClipboard() {
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    @Nullable
    @Override
    public String getContent() {
        try {
            Transferable clipData = clipboard.getContents(null);
            return (clipData != null && clipData.isDataFlavorSupported(DataFlavor.stringFlavor))
                    ? (String) clipData.getTransferData(DataFlavor.stringFlavor)
                    : null;
        } catch (UnsupportedFlavorException | IOException ignored) {
            return null;
        }
    }

    @Override
    public void setContent(@Nullable String content) {
        StringSelection data = new StringSelection(content);
        clipboard.setContents(data, null);
    }
}
