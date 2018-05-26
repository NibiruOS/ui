package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.ListWidget.DefaultRowType;
import org.nibiru.ui.core.api.Widget;

public interface UiBuilder {
    AbsolutePanelBuilder absolutePanel();

    ButtonBuilder button();

    CanvasBuilder canvas();

    CheckBoxBuilder checkbox();

    <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass);

    FramePanelBuilder framePanel();

    FormBuilder form();

    GridPanelBuilder gridPanel();

    HorizontalPanelBuilder horizontalPanel();

    HorizontalScrollPanelBuilder horizontalScrollPanel();

    ImageBuilder image();

    ImageStyleBuilder imageStyle();

    LabelBuilder label();

    <ModelType,
            RowType extends Enum<?>,
            ViewType extends Widget>
    ListWidgetBuilder<ModelType,
            RowType,
            ViewType>
    list(Class<ModelType> modelType,
         Class<RowType> rowTypeEnum,
         Class<ViewType> viewType,
         ListWidget.RowTypeHandler<RowType> rowTypeHandler);

    <ModelType,
            ViewType extends Widget>
    DefaultRowTypeListWidgetBuilder<ModelType,
            ViewType>
    list(Class<ModelType> modelType,
         Class<ViewType> viewType,
         ListWidget.DefaultRowTypeHandler rowTypeHandler);

    PasswordBoxBuilder passwordBox();

    PopupBuilder popup();

    <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass);

    RelativePanelBuilder relativePanel();

    SpinnerBuilder spinner();

    StyleBuilder style();

    TextBoxBuilder textBox();

    TextStyleBuilder textStyle();

    TreeViewBuilder treeView();

    TreeViewItemBuilder treeViewItem();

    VerticalPanelBuilder verticalPanel();

    VerticalScrollPanelBuilder verticalScrollPanel();
}
