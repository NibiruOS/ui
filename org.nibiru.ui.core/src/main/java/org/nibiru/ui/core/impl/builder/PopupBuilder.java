package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Style;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class PopupBuilder
        extends BaseBuilder<Popup>
        implements
        HasContentBuilder<Popup, PopupBuilder>,
        ObjectBuilder<Popup> {

    private final Provider<HorizontalPanelBuilder> horizontalPanel;
    private final Provider<LabelBuilder> label;
    private final Provider<SpinnerBuilder> spinner;
    private final Provider<StyleBuilder> style;
    private final Provider<TextStyleBuilder> textStyle;

    @Inject
    public PopupBuilder(Popup popup,
                        Provider<HorizontalPanelBuilder> horizontalPanel,
                        Provider<LabelBuilder> label,
                        Provider<SpinnerBuilder> spinner,
                        Provider<StyleBuilder> style,
                        Provider<TextStyleBuilder> textStyle) {
        super(popup);
        this.horizontalPanel = checkNotNull(horizontalPanel);
        this.label = checkNotNull(label);
        this.spinner = checkNotNull(spinner);
        this.style = checkNotNull(style);
        this.textStyle = checkNotNull(textStyle);
    }

    public PopupBuilder autoHide(boolean autoHide) {
        object.setAutoHide(autoHide);
        return this;
    }

    public Popup loadingPopup(String text) {
        checkNotNull(text);
        Style itemStyle = style.get()
                .verticalAlignment(Alignment.CENTER)
                .marginLeft(10)
                .marginRight(10)
                .build();
        return build(horizontalPanel.get()
                .style(style.get()
                        .backgroundColor(Color.WHITE)
                        .build())
                .add(spinner.get()
                        .style(itemStyle)
                        .build())
                .add(label.get()
                        .style(textStyle.get()
                                .parent(itemStyle)
                                .fontSize(15)
                                .build())
                        .build(text))
                .build());
    }
}
