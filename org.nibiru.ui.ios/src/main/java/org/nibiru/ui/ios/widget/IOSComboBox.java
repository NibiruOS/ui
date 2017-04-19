package org.nibiru.ui.ios.widget;

import com.google.common.collect.Lists;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ComboBox;

import java.util.List;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UIColor;
import apple.uikit.UILabel;
import apple.uikit.UIPickerView;
import apple.uikit.protocol.UIPickerViewDataSource;
import apple.uikit.protocol.UIPickerViewDelegate;

public class IOSComboBox<V> extends IOSValueWidget<UILabel, V> implements ComboBox<V> {
	private V selectedItem;
	private final Value<Iterable<V>> items;
	private final List<V> comboItems;
	private final Overlay overlay;
	private final UIPickerView picker;

	@Inject
	public IOSComboBox() {
		super(UILabel.alloc().init());
		comboItems = Lists.newArrayList();

        overlay = Overlay.create(UIColor.clearColor());
		picker = UIPickerView.alloc().init();
		picker.setBackgroundColor(UIColor.whiteColor());
        overlay.setContent(picker);
		overlay.setAutoHide(true);
		picker.setShowsSelectionIndicator(true);
		items = new BaseValue<Iterable<V>>() {
			private Iterable<V> value;

			@Override
			public Iterable<V> get() {
				return value;
			}

			@Override
			public Type<Iterable<V>> getType() {
				return JavaType.ofUnchecked(Iterable.class);
			}

			@Override
			protected void setValue(Iterable<V> value) {
				this.value = value;
				comboItems.clear();
				for (V item : value) {
					comboItems.add(item);
				}
			}
		};
		picker.setDelegate(new UIPickerViewDelegate() {
			@Override
			public void pickerViewDidSelectRowInComponent(UIPickerView pickerView, long row, long component) {
				getValue().set(comboItems.get((int) row));
			}

			@Override
			public String pickerViewTitleForRowForComponent(UIPickerView pickerView, long row, long component) {
				return comboItems.get((int) row).toString();
			}
		});
		picker.setDataSource(new UIPickerViewDataSource() {
			@Override
			public long pickerViewNumberOfRowsInComponent(UIPickerView pickerView, long component) {
				return comboItems.size();
			}

			@Override
			public long numberOfComponentsInPickerView(UIPickerView pickerView) {
				return 1;
			}
		});
		control.setUserInteractionEnabled(true);

		TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(control, () -> {
			double width = 0;
			for (V item : getItems().get()) {
				String text = item != null ? item.toString() : "";
				CGSize size = sizeFromText(text, control.font());
				if (width < size.width()) {
					width = size.width();
				}
			}
			CGPoint origin = control.superview().convertPointToView(control.frame().origin(), null);
			origin.setY(origin.y() + control.frame().size().height());
			picker.setFrame(new CGRect(origin, new CGSize(width + 64, 100)));
			overlay.show();
		});
		updateLabel();
	}

	@Override
	public Value<V> buildValue() {
		return new BaseValue<V>() {

			@Override
			public V get() {
				return selectedItem;
			}

			@Override
			public Type<V> getType() {
				return JavaType.ofUnchecked(Object.class);
			}

			@Override
			protected void setValue(V value) {
				selectedItem = value;
				updateLabel();
			}
		};
	}

	@Override
	public Value<Iterable<V>> getItems() {
		return items;
	}

	@Override
	protected int getNativeHeight() {
		return (int) size().height();
	}

	@Override
	protected int getNativeWidth() {
		return (int) size().width();
	}

	private CGSize size() {
		return sizeFromText(control.text(),control.font());
	}

	private void updateLabel() {
		control.setText("[" + (selectedItem != null ? selectedItem.toString() : "") + "]");
		scheduleLayout();
	}
}
