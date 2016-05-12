package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.Widget;

import com.google.common.collect.ImmutableList;
import com.intel.moe.natj.general.ann.NInt;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.NSIndexPath;
import ios.uikit.UITableView;
import ios.uikit.UITableViewCell;
import ios.uikit.UIView;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class IOSListWidget extends IOSValueWidget<UITableView, Iterable<Widget>> implements ListWidget {
	@Inject
	public IOSListWidget() {
		this(UITableView.alloc().initWithFrame(new CGRect(new CGPoint(0, 0), new CGSize(150, 200))));
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
				control.setDataSource(new UITableViewDataSource() {
					@Override
					public long tableViewNumberOfRowsInSection(UITableView uiTableView, @NInt long l) {
						return items.size();
					}

					@Override
					public long numberOfSectionsInTableView(UITableView tableView) {
						return 1;
					}

					@Override
					public UITableViewCell tableViewCellForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
						UIView rowView = (UIView) items.get((int)nsIndexPath.row()).asNative();
						UITableViewCell cell = UITableViewCell.alloc().init();
						cell.addSubview(rowView);
						cell.setFrame(rowView.frame());
						return cell;
					}
				});
				control.setDelegate(new UITableViewDelegate(){
					@Override
					public double tableViewEstimatedHeightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
						UIView rowView = (UIView) items.get((int)indexPath.row()).asNative();
						return rowView.frame().size().height();
					}
				});

				double width = 0;
				double height = 0;
				for (Widget childWidget : items) {
					UIView child = (UIView) childWidget.asNative();
					double childWidth = child.frame().size().width();
					double childHeight = child.frame().size().height();
					height += childHeight;
					if (childWidth > width) {
						width = childWidth;
					}
				}
				updateSize(width, height);

			}

			@Override
			public Type<Iterable<Widget>> getType() {
				return JavaType.ofIterable(Widget.class);
			}
		};
	}
}
