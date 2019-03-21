package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.ListWidget.DefaultRowType;
import org.nibiru.ui.core.api.PasswordBox;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

public interface UiBuilder {
    AbsolutePanelBuilder absolutePanel();

    ButtonBuilder button();

    default Button button(@Nullable String text) {
        return button()
                .build(text);
    }

    default Button button(@Nullable String text, ClickHandler clickHandler) {
        return button()
                .build(text, clickHandler);
    }

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

    default Label label(@Nullable String text) {
        return label()
                .build(text);
    }

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

    default PasswordBox passwordBox(@Nullable String text) {
        return passwordBox()
                .build(text);
    }

    PopupBuilder popup();

    <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass);

    RadioButtonStyleBuilder radioButtonStyle();

    RelativePanelBuilder relativePanel();

    SpinnerBuilder spinner();

    StyleBuilder style();

    TextBoxBuilder textBox();

    default TextBox textBox(@Nullable String text) {
        return textBox()
                .build(text);
    }

    TextStyleBuilder textStyle();

    TreeViewBuilder treeView();

    TreeViewItemBuilder treeViewItem();

    VerticalPanelBuilder verticalPanel();

    VerticalScrollPanelBuilder verticalScrollPanel();
}
