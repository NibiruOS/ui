package com.aajtech.ui.core.impl.builder;

import javax.annotation.Nullable;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.Widget;

public interface UiCreator {
	LabelBuilder label();

	Label label(@Nullable String text);

	TextBoxBuilder textBox();

	TextBox textBox(@Nullable String text);

	PasswordBoxBuilder passwordBox();

	PasswordBox passwordBox(@Nullable String text);

	VerticalPanelBuilder verticalPanel();

	HorizontalPanelBuilder horizontalPanel();

	GridPanelBuilder gridPanel();

	AbsolutePanelBuilder absolutePanel();

	FormBuilder form();

	ButtonBuilder button();

	Button button(@Nullable String text, ClickHandler clickHandler);

	ImageBuilder image();

	Image image(String path);

	ListWidget list();

	PopupBuilder popup();

	Popup popup(Widget content);

	SpinnerBuilder spinner();

	Popup loadingPopup(String text);

	<T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass);
	
	<T> ComboBoxBuilder<T> comboBox(Class<T> valueClass);
	
	CheckboxBuilder checkbox();

	TreeViewBuilder treeView();

	TreeViewItemBuilder treeViewItem(Widget widget);
}