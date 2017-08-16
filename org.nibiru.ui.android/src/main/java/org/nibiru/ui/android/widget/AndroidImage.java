package org.nibiru.ui.android.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.google.common.io.Closer;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;
import org.nibiru.ui.core.api.style.ImageStyle;
import org.nibiru.ui.core.api.style.ImageStyle.ScaleType;

import java.io.IOException;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidImage extends AndroidValueWidget<ImageView, String> implements Image {
    private final String basePath;

    @Inject
    public AndroidImage(Context context, @ResourcesBasePath String basePath) {
        this(new ImageView(context), basePath);
    }

    public AndroidImage(ImageView view, final String basePath) {
        super(view);
        this.basePath = checkNotNull(basePath);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof ImageStyle) {
            ImageStyle imageStyle = (ImageStyle) getStyle();
            control.setScaleType(scaleToNative(imageStyle.getScaleType()));
        }
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
                imagePath = checkNotNull(value);
                Closer closer = Closer.create();
                try {
                    try {
                        control.setImageBitmap(BitmapFactory.decodeStream(
                                closer.register(getClass().getClassLoader().getResourceAsStream(basePath + value))));
                    } catch (Throwable e) { // must catch Throwable
                        throw closer.rethrow(e);
                    } finally {
                        closer.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Override
    protected int getNativeHeight() {
        return dpToPx(super.getNativeHeight());
    }

    @Override
    protected int getNativeWidth() {
        return dpToPx(super.getNativeWidth());
    }

    private static ImageView.ScaleType scaleToNative(ScaleType scaleType) {
        switch (scaleType) {
            case FIT_CENTER:
                return ImageView.ScaleType.FIT_CENTER;
            case FIT_XY:
                return ImageView.ScaleType.FIT_XY;
            default:
                return null;
        }
    }
}
