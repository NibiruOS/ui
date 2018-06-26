package org.nibiru.ui.ios.widget;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;

import org.moe.natj.general.ptr.impl.PtrFactory;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import apple.foundation.NSData;
import apple.uikit.UIImage;
import apple.uikit.UIImageView;

import static com.google.common.base.Preconditions.checkNotNull;

public class IOSImage
        extends IOSHasEnabledWidget<UIImageView, String>
        implements Image {

    private final String basePath;

    @Inject
    public IOSImage(@ResourcesBasePath String basePath) {
        this(UIImageView.alloc().init(), basePath);
    }

    public IOSImage(UIImageView imageView, final String basePath) {
        super(imageView);
        this.basePath = checkNotNull(basePath);
    }

    @Override
    public void setBinaryContent(Format format, byte[] content) {
        checkNotNull(format);
        checkNotNull(content);
        setBinaryContent(content);
    }

    @Override
    public void setBase64Content(Format format, String content) {
        checkNotNull(format);
        checkNotNull(content);
        setBinaryContent(BaseEncoding.base64()
                .decode(content));
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            private String value;

            @Override
            public String get() {
                return value;
            }

            @Override
            protected void setValue(final String value) {
                this.value = checkNotNull(value);
                try {
                    byte[] data = new ByteSource() {
                        @Override
                        public InputStream openStream() throws IOException {
                            return getClass().getClassLoader().getResourceAsStream(basePath + value);
                        }
                    }.read();
                    setBinaryContent(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }
        };
    }

    @Override
    protected int getNativeHeight() {
        return (int) (control.image() != null ? control.image().size().height() : 0);
    }

    @Override
    protected int getNativeWidth() {
        return (int) (control.image() != null ? control.image().size().width() : 0);
    }

    private void setBinaryContent(byte[] content) {
        control.setImage(UIImage.alloc().initWithData(NSData
                .dataWithBytesLength(PtrFactory.newByteArray(content), content.length)));
    }
}
