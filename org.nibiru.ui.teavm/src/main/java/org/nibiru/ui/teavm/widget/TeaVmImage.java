package org.nibiru.ui.teavm.widget;

import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;
import org.teavm.classlib.impl.Base64;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLImageElement;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TeaVmImage extends TeaVmValueWidget<HTMLImageElement, String>
        implements Image {
    private final String basePath;
    private boolean dirty;

    @Inject
    public TeaVmImage(@ResourcesBasePath String basePath) {
        this(createElement("img"), basePath);
        control.addEventListener("onLoad", (event) -> {
            if (dirty) {
                scheduleLayout();
            }
        });
    }

    public TeaVmImage(HTMLImageElement control, String basePath) {
        super(control);
        this.basePath = checkNotNull(basePath);
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        super.setNativeSize(measuredWidth, measuredHeight);
        dirty = (measuredWidth == 0 && measuredHeight == 0);
    }

    @Override
    Value<String> buildValue() {
        return new BaseValue<String>() {
            private String imagePath;

            @Override
            public String get() {
                return imagePath;
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }

            @Override
            protected void setValue(String value) {
                checkNotNull(value);
                try (InputStream in = TeaVmImage.class.getClassLoader().getResourceAsStream(basePath + value)) {
                    imagePath = value;
                    int dotPos = value.lastIndexOf('.');
                    String type = dotPos >= 0
                            ? value.substring(dotPos)
                            : "png";
                    byte[] bytes = ByteStreams.toByteArray(in);
                    control.setSrc("data:image/" + type + ";base64," + new String(java.util.Base64.getEncoder().encode(bytes)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ;
            }
        };
    }
}
