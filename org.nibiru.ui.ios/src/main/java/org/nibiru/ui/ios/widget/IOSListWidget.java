package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewDataSourceAdapter;
import org.robovm.apple.uikit.UITableViewDelegateAdapter;
import org.robovm.apple.uikit.UIView;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.Widget;
import com.google.common.collect.ImmutableList;

public class IOSListWidget extends IOSValueWidget<UITableView, Iterable<Widget>> implements ListWidget {
	public IOSListWidget() {
		this(new UITableView(new CGRect(0, 0, 150, 200)));
	}

	public IOSListWidget(UITableView view) {
		super(view);
	}

	@Override
	Value<Iterable<Widget>> buildValue() {
		return new BaseValue<Iterable<Widget>>() {
			private List<Widget> items;

			@Override
			public Iterable<Widget> get() {
				return items;
			}

			@Override
			protected void setValue(Iterable<Widget> value) {
				this.items = ImmutableList.copyOf(checkNotNull(value));
				control.setDataSource(new UITableViewDataSourceAdapter() {
					@Override
					public long getNumberOfRowsInSection(UITableView tableView, long section) {
						return items.size();
					}

					@Override
					public long getNumberOfSections(UITableView tableView) {
						return 1;
					}

					@Override
					public UITableViewCell getCellForRow(UITableView tableView, NSIndexPath indexPath) {
						UIView rowView = (UIView) items.get(indexPath.getRow()).asNative();
						UITableViewCell cell = new UITableViewCell();
						cell.addSubview(rowView);
						cell.setFrame(rowView.getFrame());
						return cell;
					}
				});
				control.setDelegate(new UITableViewDelegateAdapter(){
					@Override
					public double getHeightForRow(UITableView tableView, NSIndexPath indexPath) {
						UIView rowView = (UIView) items.get(indexPath.getRow()).asNative();
						return rowView.getFrame().getHeight();
					}
				});

				double width = 0;
				double height = 0;
				for (Widget childWidget : items) {
					UIView child = (UIView) childWidget.asNative();
					double childWidth = child.getFrame().getWidth();
					double childHeight = child.getFrame().getHeight();
					height += childHeight;
					if (childWidth > width) {
						width = childWidth;
					}
				}
				updateSize((int)width, (int)height);

			}

			@Override
			public Type<Iterable<Widget>> getType() {
				return JavaType.ofIterable(Widget.class);
			}
		};
	}
}
