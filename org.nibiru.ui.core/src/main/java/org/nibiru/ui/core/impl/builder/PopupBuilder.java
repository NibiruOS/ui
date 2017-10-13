package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Style;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class PopupBuilder extends BaseBuilder<Popup> {
    private final Provider<HorizontalPanelBuilder> horizontalPanel;
    private final Provider<LabelBuilder> label;
    private final Provider<SpinnerBuilder> spinner;
    private final Provider<StyleBuilder> style;
    private final Provider<TextStyleBuilder> textStyle;

    @Inject
    public PopupBuilder(Popup widget,
                        Provider<HorizontalPanelBuilder> horizontalPanel,
                        Provider<LabelBuilder> label,
                        Provider<SpinnerBuilder> spinner,
                        Provider<StyleBuilder> style,
                        Provider<TextStyleBuilder> textStyle) {
        super(widget);
        this.horizontalPanel = checkNotNull(horizontalPanel);
        this.label = checkNotNull(label);
        this.spinner = checkNotNull(spinner);
        this.style = checkNotNull(style);
        this.textStyle = checkNotNull(textStyle);
    }

    public PopupBuilder content(Widget content) {
        object.setContent(content);
        return this;
    }

    public PopupBuilder autoHide(boolean autoHide) {
        object.setAutoHide(autoHide);
        return this;
    }

    public Popup build(Widget content) {
        checkNotNull(content);
        return content(content).build();
    }

    public Popup loadingPopup(String text) {
        checkNotNull(text);
        Style itemStyle = style.get()
                .verticalAlignment(Alignment.CENTER)
                .marginLeft(10)
                .marginRight(10)
                .build();
        return build(horizontalPanel.get()
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
