package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;

import com.google.common.io.ByteSource;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UIImage;
import ios.uikit.UIImageView;

public class IOSImage extends IOSValueWidget<UIImageView, String> implements Image {
    private final String basePath;

    @Inject
    public IOSImage(@ResourcesBasePath String basePath) {
        this(buildImage(), basePath);
    }

    private static UIImageView buildImage() {
        UIImageView image = UIImageView.alloc().init();
        image.setFrame(new CGRect(new CGPoint(0, 0), new CGSize(50, 50)));
        return image;
    }

    public IOSImage(UIImageView imageView, final String basePath) {
        super(imageView);
        this.basePath = checkNotNull(basePath);
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
                ByteSource source = new ByteSource() {
                    @Override
                    public InputStream openStream() throws IOException {
                        return getClass().getClassLoader().getResourceAsStream(basePath + value);
                    }
                };
                // FIXME: Read image data into NSData
                UIImage image = UIImage.imageNamed("CHANGEME");
                control.setImage(image);
                //updateSize(image.size().width(), image.size().height());
                updateSize(50, 50);
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }
        };
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        // TODO Auto-generated method stub
        return null;
    }
}
