package org.nibiru.ui.ios.widget;

import com.google.common.collect.Lists;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.RadioButtonGroup;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UILabel;
import apple.uikit.UIView;

import static org.nibiru.ui.ios.widget.WidgetUtils.sizeFromText;

public class IOSRadioButtonGroup<V>
        extends IOSHasEnabledWidget<UIView, V>
        implements RadioButtonGroup<V> {

    private V selectedItem;
    private final Value<Iterable<V>> items;
    private final List<UILabel> labels;
    private double rowHeight;
    private double rowWidth;

    @Inject
    public IOSRadioButtonGroup() {
        super(UIView.alloc().init());
        labels = Lists.newArrayList();

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
                for (UIView child : control.subviews()) {
                    child.removeFromSuperview();
                }
                labels.clear();
                rowHeight = 0;
                rowWidth = 0;
                for (V item : value) {
                    UILabel label = UILabel.alloc().init();
                    control.addSubview(label);
                    labels.add(label);
                    TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(label, () -> getValue().set(item));
                    String text = item != null ? item.toString() : "";
                    CGSize size = sizeFromText("+" + text, label.font());
                    if (rowHeight < size.height()) {
                        rowHeight = size.height();
                    }
                    if (rowWidth < size.width()) {
                        rowWidth = size.width();
                    }
                }
                int n = 0;
                for (UILabel label : labels) {
                    label.setFrame(new CGRect(new CGPoint(0, n * rowHeight), new CGSize(rowWidth, rowHeight)));
                    n++;
                }
                updateLabels();
            }
        };
    }

    @Override
    public Value<Iterable<V>> getItems() {
        return items;
    }

    @Override
    Value<V> buildValue() {
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
                updateLabels();
            }
        };
    }


    @Override
    protected int getNativeHeight() {
        return (int) (rowHeight * labels.size());
    }

    @Override
    protected int getNativeWidth() {
        return (int) rowWidth;
    }

    private void updateLabels() {
        if (items.get() != null) {
            int n = 0;
            for (V item : items.get()) {
                UILabel label = labels.get(n);
                String text = item != null ? item.toString() : "";
                label.setText((Objects.equals(item, selectedItem) ? "+" : " ") + text);
                n++;
            }
        }
    }
}
