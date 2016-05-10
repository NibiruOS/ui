package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.ScrollPanel;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.Widget;

public class UiBuilder implements UiCreator {
	private final Provider<LabelBuilder> labelBuilderProvider;
	private final Provider<TextBoxBuilder> textBoxBuilderProvider;
	private final Provider<PasswordBoxBuilder> passwordBoxBuilderProvider;
	private final Provider<VerticalPanelBuilder> verticalPanelBuilderProvider;
	private final Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider;
	private final Provider<GridPanelBuilder> gridPanelBuilderProvider;
	private final Provider<AbsolutePanelBuilder> absolutePanelBuilderProvider;
	private final Provider<ScrollPanelBuilder> scrollPanelBuilderProvider;
	private final Provider<FormBuilder> formBuilderProvider;
	private final Provider<ButtonBuilder> buttonBuilderProvider;
	private final Provider<ListWidget> listWidgetProvider;
	private final Provider<ImageBuilder> imageBuilderProvider;
	private final Provider<PopupBuilder> popupBuilderProvider;
	private final Provider<SpinnerBuilder> spinnerBuilderProvider;
	private final RadioButtonGroupBuilderFactory radioButtonGroupBuilderFactory;
	private final ComboBoxBuilderFactory comboBoxBuilderFactory;
	private final Provider<CheckboxBuilder> checkboxBuilderProvider;
	private final Provider<TreeViewBuilder> treeViewBuilderProvider;
	private final Provider<TreeViewItemBuilder> treeViewItemBuilderProvider;

	@Inject
	public UiBuilder(Provider<LabelBuilder> labelBuilderProvider,
			Provider<TextBoxBuilder> textBoxBuilderProvider,
			Provider<PasswordBoxBuilder> passwordBoxBuilderProvider,
			Provider<VerticalPanelBuilder> verticalPanelBuilderProvider,
			Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider,
			Provider<GridPanelBuilder> gridPanelBuilderProvider,
			Provider<AbsolutePanelBuilder> absolutePanelBuilderProvider,
			Provider<ScrollPanelBuilder> scrollPanelBuilderProvider,
			Provider<FormBuilder> formBuilderProvider,
			Provider<ButtonBuilder> buttonBuilderProvider,
			Provider<ListWidget> listWidgetProvider,
			Provider<ImageBuilder> imageBuilderProvider,
			Provider<PopupBuilder> popupBuilderProvider,
			Provider<SpinnerBuilder> spinnerBuilderProvider,
			RadioButtonGroupBuilderFactory radioButtonGroupBuilderFactory,
			ComboBoxBuilderFactory comboBoxBuilderFactory,
			Provider<CheckboxBuilder> checkboxBuilderProvider,
			Provider<TreeViewBuilder> treeViewBuilderProvider,
			Provider<TreeViewItemBuilder> treeViewItemBuilderProvider) {
		this.labelBuilderProvider = checkNotNull(labelBuilderProvider);
		this.textBoxBuilderProvider = checkNotNull(textBoxBuilderProvider);
		this.passwordBoxBuilderProvider = checkNotNull(passwordBoxBuilderProvider);
		this.verticalPanelBuilderProvider = checkNotNull(verticalPanelBuilderProvider);
		this.horizontalPanelBuilderProvider = checkNotNull(horizontalPanelBuilderProvider);
		this.gridPanelBuilderProvider = checkNotNull(gridPanelBuilderProvider);
		this.absolutePanelBuilderProvider = checkNotNull(absolutePanelBuilderProvider);
		this.scrollPanelBuilderProvider = checkNotNull(scrollPanelBuilderProvider);
		this.formBuilderProvider = checkNotNull(formBuilderProvider);
		this.buttonBuilderProvider = checkNotNull(buttonBuilderProvider);
		this.listWidgetProvider = checkNotNull(listWidgetProvider);
		this.imageBuilderProvider = checkNotNull(imageBuilderProvider);
		this.popupBuilderProvider = checkNotNull(popupBuilderProvider);
		this.spinnerBuilderProvider = checkNotNull(spinnerBuilderProvider);
		this.radioButtonGroupBuilderFactory = checkNotNull(radioButtonGroupBuilderFactory);
		this.comboBoxBuilderFactory = checkNotNull(comboBoxBuilderFactory);
		this.checkboxBuilderProvider = checkNotNull(checkboxBuilderProvider);
		this.treeViewBuilderProvider = checkNotNull(treeViewBuilderProvider);
		this.treeViewItemBuilderProvider = checkNotNull(treeViewItemBuilderProvider);
	}

	@Override
	public LabelBuilder label() {
		return labelBuilderProvider.get();
	}

	@Override
	public Label label(@Nullable String text) {
		return label().value(text).build();
	}

	@Override
	public TextBoxBuilder textBox() {
		return textBoxBuilderProvider.get();
	}

	@Override
	public TextBox textBox(@Nullable String text) {
		return textBox().value(text).build();
	}

	@Override
	public PasswordBoxBuilder passwordBox() {
		return passwordBoxBuilderProvider.get();
	}

	@Override
	public PasswordBox passwordBox(@Nullable String text) {
		return passwordBox().value(text).build();
	}
	
	@Override
	public VerticalPanelBuilder verticalPanel() {
		return verticalPanelBuilderProvider.get();
	}

	@Override
	public HorizontalPanelBuilder horizontalPanel() {
		return horizontalPanelBuilderProvider.get();
	}

	@Override
	public GridPanelBuilder gridPanel() {
		return gridPanelBuilderProvider.get();
	}

	@Override
	public AbsolutePanelBuilder absolutePanel() {
		return absolutePanelBuilderProvider.get();
	}

	@Override
	public ScrollPanelBuilder scrollPanel() {
		return scrollPanelBuilderProvider.get();
	}

	@Override
	public ScrollPanel scrollPanel(Widget content) {
		return scrollPanel().content(content).build();
	}

	@Override
	public FormBuilder form() {
		return formBuilderProvider.get();
	}

	@Override
	public ButtonBuilder button() {
		return buttonBuilderProvider.get();
	}

	@Override
	public Button button(@Nullable String text, ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		return button().value(text).onClick(clickHandler).build();
	}

	@Override
	public ListWidget list() {
		return listWidgetProvider.get();
	}

	@Override
	public ImageBuilder image() {
		return imageBuilderProvider.get();
	}

	@Override
	public Image image(String path) {
		checkNotNull(path);
		return image().value(path).build();
	}

	@Override
	public PopupBuilder popup() {
		return popupBuilderProvider.get();
	}

	@Override
	public Popup popup(Widget content) {
		checkNotNull(content);
		return popup().content(content).build();
	}

	@Override
	public SpinnerBuilder spinner() {
		return spinnerBuilderProvider.get();
	}

	@Override
	public Popup loadingPopup(String text) {
		checkNotNull(text);
		return popup(horizontalPanel()
			.add(spinner().build())
			.add(label(text))
			.build());
	}

	@Override
	public <T> RadioButtonGroupBuilder<T> radioButtonGroup(Class<T> valueClass) {
		return radioButtonGroupBuilderFactory.create(valueClass);
	}
	
	@Override
	public CheckboxBuilder checkbox() {
		return checkboxBuilderProvider.get();
	}

	@Override
	public <T> ComboBoxBuilder<T> comboBox(Class<T> valueClass) {
		return comboBoxBuilderFactory.create(valueClass);
	}

	@Override
	public TreeViewBuilder treeView() {
		return treeViewBuilderProvider.get();
	}

	@Override
	public TreeViewItemBuilder treeViewItem(Widget widget) {
		return treeViewItemBuilderProvider.get().widget(widget);
	}
}
