package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.ListWidget.DefaultRowType;
import org.nibiru.ui.core.api.ListWidget.DefaultRowTypeHandler;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class UiBuilderImpl
        implements UiBuilder {
    private final Provider<AbsolutePanelBuilder> absolutePanel;
    private final Provider<ButtonBuilder> button;
    private final Provider<CanvasBuilder> canvas;
    private final Provider<CheckBoxBuilder> checkBox;
    private final ComboBoxBuilderFactory comboBox;
    private final Provider<FramePanelBuilder> framePanel;
    private final Provider<FormBuilder> form;
    private final Provider<GridPanelBuilder> gridPanel;
    private final Provider<HorizontalPanelBuilder> horizontalPanel;
    private final Provider<HorizontalScrollPanelBuilder> horizontalScrollPanel;
    private final Provider<ImageBuilder> image;
    private final Provider<ImageStyleBuilder> imageStyle;
    private final Provider<LabelBuilder> label;
    private final ListWidgetBuilderFactory listWidget;
    private final Provider<PasswordBoxBuilder> passwordBox;
    private final Provider<PopupBuilder> popup;
    private final RadioButtonGroupBuilderFactory radioButtonGroup;
    private final Provider<RelativePanelBuilder> relativePanel;
    private final Provider<SpinnerBuilder> spinner;
    private final Provider<StyleBuilder> style;
    private final Provider<TextBoxBuilder> textBox;
    private final Provider<TextStyleBuilder> textStyle;
    private final Provider<TreeViewBuilder> treeView;
    private final Provider<TreeViewItemBuilder> treeViewItem;
    private final Provider<VerticalPanelBuilder> verticalPanel;
    private final Provider<VerticalScrollPanelBuilder> verticalScrollPanel;

    @Inject
    public UiBuilderImpl(Provider<AbsolutePanelBuilder> absolutePanel,
                         Provider<ButtonBuilder> button,
                         Provider<CanvasBuilder> canvas,
                         Provider<CheckBoxBuilder> checkBox,
                         ComboBoxBuilderFactory comboBox,
                         Provider<FramePanelBuilder> framePanel,
                         Provider<FormBuilder> form,
                         Provider<GridPanelBuilder> gridPanel,
                         Provider<HorizontalPanelBuilder> horizontalPanel,
                         Provider<HorizontalScrollPanelBuilder> horizontalScrollPanel,
                         Provider<ImageBuilder> image,
                         Provider<ImageStyleBuilder> imageStyle,
                         Provider<LabelBuilder> label,
                         ListWidgetBuilderFactory listWidget,
                         Provider<PasswordBoxBuilder> passwordBox,
                         Provider<PopupBuilder> popup,
                         RadioButtonGroupBuilderFactory radioButtonGroup,
                         Provider<RelativePanelBuilder> relativePanel,
                         Provider<SpinnerBuilder> spinner,
                         Provider<StyleBuilder> style,
                         Provider<TextBoxBuilder> textBox,
                         Provider<TextStyleBuilder> textStyle,
                         Provider<TreeViewBuilder> treeView,
                         Provider<TreeViewItemBuilder> treeViewItem,
                         Provider<VerticalPanelBuilder> verticalPanel,
                         Provider<VerticalScrollPanelBuilder> verticalScrollPanel) {
        this.absolutePanel = checkNotNull(absolutePanel);
        this.button = checkNotNull(button);
        this.canvas = checkNotNull(canvas);
        this.checkBox = checkNotNull(checkBox);
        this.comboBox = checkNotNull(comboBox);
        this.framePanel = checkNotNull(framePanel);
        this.form = checkNotNull(form);
        this.gridPanel = checkNotNull(gridPanel);
        this.horizontalPanel = checkNotNull(horizontalPanel);
        this.horizontalScrollPanel = checkNotNull(horizontalScrollPanel);
        this.image = checkNotNull(image);
        this.imageStyle = checkNotNull(imageStyle);
        this.label = checkNotNull(label);
        this.listWidget = checkNotNull(listWidget);
        this.passwordBox = checkNotNull(passwordBox);
        this.popup = checkNotNull(popup);
        this.radioButtonGroup = checkNotNull(radioButtonGroup);
        this.relativePanel = checkNotNull(relativePanel);
        this.spinner = checkNotNull(spinner);
        this.style = checkNotNull(style);
        this.textBox = checkNotNull(textBox);
        this.textStyle = checkNotNull(textStyle);
        this.treeView = checkNotNull(treeView);
        this.treeViewItem = checkNotNull(treeViewItem);
        this.verticalPanel = checkNotNull(verticalPanel);
        this.verticalScrollPanel = checkNotNull(verticalScrollPanel);
    }

    @Override
    public AbsolutePanelBuilder absolutePanel() {
        return absolutePanel.get();
    }

    @Override
    public ButtonBuilder button() {
        return button.get();
    }

    @Override
    public CanvasBuilder canvas() {
        return canvas.get();
    }

    @Override
    public CheckBoxBuilder checkbox() {
        return checkBox.get();
    }

    @Override
    public <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass) {
        return comboBox.create(valueClass);
    }

    @Override
    public FramePanelBuilder framePanel() {
        return framePanel.get();
    }

    @Override
    public FormBuilder form() {
        return form.get();
    }

    @Override
    public GridPanelBuilder gridPanel() {
        return gridPanel.get();
    }

    @Override
    public HorizontalPanelBuilder horizontalPanel() {
        return horizontalPanel.get();
    }

    @Override
    public HorizontalScrollPanelBuilder horizontalScrollPanel() {
        return horizontalScrollPanel.get();
    }

    @Override
    public ImageBuilder image() {
        return image.get();
    }

    @Override
    public ImageStyleBuilder imageStyle() {
        return imageStyle.get();
    }

    @Override
    public LabelBuilder label() {
        return label.get();
    }

    @Override
    public <ModelType, RowType extends Enum<?>,
            ViewType extends Widget>
    ListWidgetBuilder<ModelType,
            RowType,
            ViewType>
    list(Class<ModelType> modelType,
         Class<RowType> rowTypeEnum,
         Class<ViewType> viewType,
         ListWidget.RowTypeHandler<RowType> rowTypeHandler) {
        return listWidget.create(modelType, rowTypeEnum, viewType, rowTypeHandler);
    }

    @Override
    public <ModelType,
            ViewType extends Widget>
    DefaultRowTypeListWidgetBuilder<ModelType,
            ViewType>
    list(Class<ModelType> modelType,
         Class<ViewType> viewType,
         DefaultRowTypeHandler rowTypeHandler) {
        return listWidget.create(modelType, viewType, rowTypeHandler);
    }

    @Override
    public PasswordBoxBuilder passwordBox() {
        return passwordBox.get();
    }

    @Override
    public PopupBuilder popup() {
        return popup.get();
    }

    @Override
    public <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass) {
        return radioButtonGroup.create(valueClass);
    }

    @Override
    public RelativePanelBuilder relativePanel() {
        return relativePanel.get();
    }

    @Override
    public SpinnerBuilder spinner() {
        return spinner.get();
    }

    @Override
    public StyleBuilder style() {
        return style.get();
    }

    @Override
    public TextBoxBuilder textBox() {
        return textBox.get();
    }

    @Override
    public TextStyleBuilder textStyle() {
        return textStyle.get();
    }

    @Override
    public TreeViewBuilder treeView() {
        return treeView.get();
    }

    @Override
    public TreeViewItemBuilder treeViewItem() {
        return treeViewItem.get();
    }

    @Override
    public VerticalPanelBuilder verticalPanel() {
        return verticalPanel.get();
    }

    @Override
    public VerticalScrollPanelBuilder verticalScrollPanel() {
        return verticalScrollPanel.get();
    }
}
