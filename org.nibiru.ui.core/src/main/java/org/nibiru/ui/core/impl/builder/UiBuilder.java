package org.nibiru.ui.core.impl.builder;

public interface UiBuilder {
    AbsolutePanelBuilder absolutePanel();

    ButtonBuilder button();

    CheckBoxBuilder checkbox();

    <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass);

    FormBuilder form();

    GridPanelBuilder gridPanel();

    HorizontalPanelBuilder horizontalPanel();

    HorizontalScrollPanelBuilder horizontalScrollPanel();

    ImageBuilder image();

    ImageStyleBuilder imageStyle();

    LabelBuilder label();

    ListWidgetBuilder list();

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
