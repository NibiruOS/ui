package com.aajtech.ui.android.ioc;

import com.aajtech.ui.android.builder.AndroidComboBoxBuilderFactory;
import com.aajtech.ui.android.builder.AndroidRadioButtonGroupBuilderFactory;
import com.aajtech.ui.android.widget.AndroidAbsolutePanel;
import com.aajtech.ui.android.widget.AndroidButton;
import com.aajtech.ui.android.widget.AndroidCheckbox;
import com.aajtech.ui.android.widget.AndroidImage;
import com.aajtech.ui.android.widget.AndroidLabel;
import com.aajtech.ui.android.widget.AndroidListWidget;
import com.aajtech.ui.android.widget.AndroidPasswordBox;
import com.aajtech.ui.android.widget.AndroidPopup;
import com.aajtech.ui.android.widget.AndroidScrollPanel;
import com.aajtech.ui.android.widget.AndroidSpinner;
import com.aajtech.ui.android.widget.AndroidTextBox;
import com.aajtech.ui.android.widget.AndroidTreeView;
import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.Checkbox;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.ScrollPanel;
import com.aajtech.ui.core.api.Spinner;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.impl.builder.AbsolutePanelBuilder;
import com.aajtech.ui.core.impl.builder.ButtonBuilder;
import com.aajtech.ui.core.impl.builder.CheckboxBuilder;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilder;
import com.aajtech.ui.core.impl.GridPanelImpl;
import com.aajtech.ui.core.impl.HorizontalPanelImpl;
import com.aajtech.ui.core.impl.VerticalPanelImpl;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilderFactory;
import com.aajtech.ui.core.impl.builder.FormBuilder;
import com.aajtech.ui.core.impl.builder.GridPanelBuilder;
import com.aajtech.ui.core.impl.builder.HorizontalPanelBuilder;
import com.aajtech.ui.core.impl.builder.ImageBuilder;
import com.aajtech.ui.core.impl.builder.LabelBuilder;
import com.aajtech.ui.core.impl.builder.ListWidgetBuilder;
import com.aajtech.ui.core.impl.builder.PasswordBoxBuilder;
import com.aajtech.ui.core.impl.builder.PopupBuilder;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilder;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import com.aajtech.ui.core.impl.builder.ScrollPanelBuilder;
import com.aajtech.ui.core.impl.builder.SpinnerBuilder;
import com.aajtech.ui.core.impl.builder.TextBoxBuilder;
import com.aajtech.ui.core.impl.builder.TreeViewBuilder;
import com.aajtech.ui.core.impl.builder.TreeViewItemBuilder;
import com.aajtech.ui.core.impl.builder.VerticalPanelBuilder;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(Button.class).to(AndroidButton.class);
		bind(Label.class).to(AndroidLabel.class);
		bind(TextBox.class).to(AndroidTextBox.class);
		bind(PasswordBox.class).to(AndroidPasswordBox.class);
		bind(ScrollPanel.class).to(AndroidScrollPanel.class);
		bind(ListWidget.class).to(AndroidListWidget.class);
		bind(Image.class).to(AndroidImage.class);
		bind(Popup.class).to(AndroidPopup.class);
		bind(Spinner.class).to(AndroidSpinner.class);
		bind(Checkbox.class).to(AndroidCheckbox.class);
		bind(RadioButtonGroupBuilderFactory.class).to(AndroidRadioButtonGroupBuilderFactory.class);
		bind(ComboBoxBuilderFactory.class).to(AndroidComboBoxBuilderFactory.class);
		bind(TreeView.class).to(AndroidTreeView.class);
		bind(AbsolutePanel.class).to(AndroidAbsolutePanel.class);

		// Generic bindings
		bind(VerticalPanel.class).to(VerticalPanelImpl.class);
		bind(HorizontalPanel.class).to(HorizontalPanelImpl.class);
		bind(GridPanel.class).to(GridPanelImpl.class);

		requestStaticInjection(AbsolutePanelBuilder.class);
		requestStaticInjection(ButtonBuilder.class);
		requestStaticInjection(CheckboxBuilder.class);
		requestStaticInjection(ComboBoxBuilder.class);
		requestStaticInjection(FormBuilder.class);
		requestStaticInjection(GridPanelBuilder.class);
		requestStaticInjection(HorizontalPanelBuilder.class);
		requestStaticInjection(ImageBuilder.class);
		requestStaticInjection(LabelBuilder.class);
		requestStaticInjection(ListWidgetBuilder.class);
		requestStaticInjection(PasswordBoxBuilder.class);
		requestStaticInjection(PopupBuilder.class);
		requestStaticInjection(RadioButtonGroupBuilder.class);
		requestStaticInjection(ScrollPanelBuilder.class);
		requestStaticInjection(SpinnerBuilder.class);
		requestStaticInjection(TextBoxBuilder.class);
		requestStaticInjection(TreeViewBuilder.class);
		requestStaticInjection(TreeViewItemBuilder.class);
		requestStaticInjection(VerticalPanelBuilder.class);
	}
}
