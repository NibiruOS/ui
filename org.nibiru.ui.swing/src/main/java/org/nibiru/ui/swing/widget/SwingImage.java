package org.nibiru.ui.swing.widget;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static com.google.common.base.Preconditions.checkNotNull;

public class SwingImage
        extends SwingHasEnabledWidget<JLabel, String>
        implements Image {

    private final String basePath;
    private Registration onClickRegistration;

    @Inject
    public SwingImage(@ResourcesBasePath String basePath) {
        this(new JLabel(), basePath);
    }

    public SwingImage(JLabel imagePanel, final String basePath) {
        super(imagePanel);
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
    public Registration setClickHandler(ClickHandler clickHandler) {
        if (onClickRegistration != null) {
            onClickRegistration.remove();
        }
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                clickHandler.onClick();
            }
        };
        control.addMouseListener(listener);
        onClickRegistration = () -> control.removeMouseListener(listener);
        return onClickRegistration;
    }

    private void setBinaryContent(byte[] content) {
        try {
            control.setIcon(new ImageIcon(ImageIO.read(new ByteArrayInputStream(content))));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
