package org.nibiru.ui.core.api;

public interface Image
        extends ValueWidget<String>, HasClickHandler, HasEnabled {

    enum Format {PNG, JPEG, GIF}

    void setBinaryContent(Format format, byte[] content);

    void setBase64Content(Format format, String content);
}
