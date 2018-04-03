package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Image;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImageBuilder
        extends BaseBuilder<Image>
        implements
        HasClickHandlerBuilder<Image, ImageBuilder>,
        HasEnabledBuilder<Image, ImageBuilder>,
        ValueWidgetBuilder<Image, String, ImageBuilder> {

    @Inject
    public ImageBuilder(Image image) {
        super(image);
    }

    public ImageBuilder binaryContent(Image.Format format, byte[] content) {
        checkNotNull(format);
        checkNotNull(content);
        object.setBinaryContent(format, content);
        return this;
    }

    public ImageBuilder base64Content(Image.Format format, String content) {
        checkNotNull(format);
        checkNotNull(content);
        object.setBase64Content(format, content);
        return this;
    }
}
