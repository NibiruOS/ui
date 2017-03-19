package org.nibiru.ui.dotnet.widget;

import com.google.common.io.ByteSource;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class DotNetImage
        extends DotNetValueWidget<cli.System.Windows.Controls.Image, String>
        implements Image {
    private final String basePath;

    @Inject
    public DotNetImage(@ResourcesBasePath String basePath) {
        this(new cli.System.Windows.Controls.Image(), basePath);
    }

    public DotNetImage(cli.System.Windows.Controls.Image control,
                       String basePath) {
        super(control);
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
                try {
                    byte[] data = new ByteSource() {
                        @Override
                        public InputStream openStream() throws IOException {
                            return getClass().getClassLoader().getResourceAsStream(basePath + value);
                        }
                    }.read();
//					MemoryStream stream = new MemoryStream();
//					BitmapImage image = new BitmapImage();
//					control.set_Source(new StreamSource() {
//					});
//					control.setImage(UIImage.alloc()
//							.initWithData(NSData.dataWithBytesLength(PtrFactory.newByteArray(data), data.length)));
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
        return 50;
    }

    @Override
    protected int getNativeWidth() {
        return 50;
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        return () -> {
        };
    }
}
