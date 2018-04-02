package org.nibiru.ui.core.impl.builder;

public interface UiBuilderWrapper
        extends UiBuilder {
    UiBuilder uiBuilder();

    @Override
    default AbsolutePanelBuilder absolutePanel() {
        return uiBuilder().absolutePanel();
    }

    @Override
    default ButtonBuilder button() {
        return uiBuilder().button();
    }

    @Override
    default CheckBoxBuilder checkbox() {
        return uiBuilder().checkbox();
    }

    @Override
    default <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass) {
        return uiBuilder().comboBox(valueClass);
    }

    @Override
    default FormBuilder form() {
        return uiBuilder().form();
    }

    @Override
    default GridPanelBuilder gridPanel() {
        return uiBuilder().gridPanel();
    }

    @Override
    default HorizontalPanelBuilder horizontalPanel() {
        return uiBuilder().horizontalPanel();
    }

    @Override
    default HorizontalScrollPanelBuilder horizontalScrollPanel() {
        return uiBuilder().horizontalScrollPanel();
    }

    @Override
    default ImageBuilder image() {
        return uiBuilder().image();
    }

    @Override
    default ImageStyleBuilder imageStyle() {
        return uiBuilder().imageStyle();
    }

    @Override
    default LabelBuilder label() {
        return uiBuilder().label();
    }

    @Override
    default ListWidgetBuilder list() {
        return uiBuilder().list();
    }

    @Override
    default PasswordBoxBuilder passwordBox() {
        return uiBuilder().passwordBox();
    }

    @Override
    default PopupBuilder popup() {
        return uiBuilder().popup();
    }

    @Override
    default <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass) {
        return uiBuilder().radioButtonGroup(valueClass);
    }

    @Override
    default RelativePanelBuilder relativePanel() {
        return uiBuilder().relativePanel();
    }

    @Override
    default SpinnerBuilder spinner() {
        return uiBuilder().spinner();
    }

    @Override
    default StyleBuilder style() {
        return uiBuilder().style();
    }

    @Override
    default TextBoxBuilder textBox() {
        return uiBuilder().textBox();
    }

    @Override
    default TextStyleBuilder textStyle() {
        return uiBuilder().textStyle();
    }

    @Override
    default TreeViewBuilder treeView() {
        return uiBuilder().treeView();
    }

    @Override
    default TreeViewItemBuilder treeViewItem() {
        return uiBuilder().treeViewItem();
    }

    @Override
    default VerticalPanelBuilder verticalPanel() {
        return uiBuilder().verticalPanel();
    }

    @Override
    default VerticalScrollPanelBuilder verticalScrollPanel() {
        return uiBuilder().verticalScrollPanel();
    }
}
