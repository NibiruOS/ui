package com.aajtech.ui.gwt.ioc;

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
import com.aajtech.ui.gwt.builder.GwtComboBoxBuilderFactory;
import com.aajtech.ui.gwt.builder.GwtRadioButtonGroupBuilderFactory;
import com.aajtech.ui.gwt.widget.GwtAbsolutePanel;
import com.aajtech.ui.gwt.widget.GwtButton;
import com.aajtech.ui.gwt.widget.GwtCheckbox;
import com.aajtech.ui.gwt.widget.GwtGridPanel;
import com.aajtech.ui.gwt.widget.GwtHorizontalPanel;
import com.aajtech.ui.gwt.widget.GwtImage;
import com.aajtech.ui.gwt.widget.GwtLabel;
import com.aajtech.ui.gwt.widget.GwtListWidget;
import com.aajtech.ui.gwt.widget.GwtPasswordBox;
import com.aajtech.ui.gwt.widget.GwtPopup;
import com.aajtech.ui.gwt.widget.GwtScrollPanel;
import com.aajtech.ui.gwt.widget.GwtSpinner;
import com.aajtech.ui.gwt.widget.GwtTextBox;
import com.aajtech.ui.gwt.widget.GwtTreeView;
import com.aajtech.ui.gwt.widget.GwtVerticalPanel;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

public class Module extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(Label.class).to(GwtLabel.class);
		bind(TextBox.class).to(GwtTextBox.class);
		bind(PasswordBox.class).to(GwtPasswordBox.class);
		bind(HorizontalPanel.class).to(GwtHorizontalPanel.class);
		bind(VerticalPanel.class).to(GwtVerticalPanel.class);
		bind(GridPanel.class).to(GwtGridPanel.class);
		bind(ScrollPanel.class).to(GwtScrollPanel.class);
		bind(Button.class).to(GwtButton.class);
		bind(ListWidget.class).to(GwtListWidget.class);
		bind(Image.class).to(GwtImage.class);
		bind(Popup.class).to(GwtPopup.class);
		bind(Spinner.class).to(GwtSpinner.class);
		bind(RadioButtonGroupBuilderFactory.class).to(GwtRadioButtonGroupBuilderFactory.class);
		bind(Checkbox.class).to(GwtCheckbox.class);
		bind(ComboBoxBuilderFactory.class).to(GwtComboBoxBuilderFactory.class);
		bind(TreeView.class).to(GwtTreeView.class);
		bind(AbsolutePanel.class).to(GwtAbsolutePanel.class);

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

	@Provides
	public Scheduler getScheduler() {
		return Scheduler.get();
	}
}
