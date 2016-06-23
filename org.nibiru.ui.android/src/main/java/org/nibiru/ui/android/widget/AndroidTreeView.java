package org.nibiru.ui.android.widget;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.TreeView.Item;

import com.google.common.collect.Iterables;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AndroidTreeView extends AndroidValueWidget<RelativeLayout, Iterable<Item>>implements TreeView {
	@Inject
	public AndroidTreeView(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidTreeView(RelativeLayout control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	@Override
	Value<Iterable<Item>> buildValue() {
		return new BaseValue<Iterable<Item>>() {
			private Iterable<Item> items;

			@Override
			public Iterable<Item> get() {
				return items;
			}

			@Override
			protected void setValue(@Nullable Iterable<Item> value) {
				items = value;
				RelativeLayout control = control();
				control.removeAllViews();
				if (items != null) {
					addItems(items, control);
				}
			}

			@Override
			public Type<Iterable<Item>> getType() {
				return JavaType.ofIterable(Item.class);
			}

			private void addItems(Iterable<Item> items, RelativeLayout parent) {
				int viewId = 0;
				int lastView = 0;
				for (Item item : items) {
					View itemView = (View) item.getWidget().asNative();

					RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
					lay.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
					if (lastView == 0) {
						lay.addRule(RelativeLayout.ALIGN_PARENT_TOP);
					} else {
						lay.addRule(RelativeLayout.BELOW, lastView);
					}

					if (Iterables.isEmpty(item.getChildren())) {
						lay.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
						parent.addView(itemView, lay);
						itemView.setId(++viewId);
						lastView = itemView.getId();
					} else {
						TextView button = new TextView(parent.getContext());
						button.setText("+");
						button.setPadding(10, 10, 10, 10);
						button.setId(++viewId);
						parent.addView(button, lay);

						RelativeLayout.LayoutParams itemLay = new RelativeLayout.LayoutParams(
								RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						itemLay.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
						itemLay.addRule(RelativeLayout.ALIGN_TOP, button.getId());
						itemLay.addRule(RelativeLayout.ALIGN_BOTTOM, button.getId());
						itemLay.addRule(RelativeLayout.RIGHT_OF, button.getId());
						itemView.setId(++viewId);
						parent.addView(itemView, itemLay);

						RelativeLayout.LayoutParams childLay = new RelativeLayout.LayoutParams(
								RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						childLay.addRule(RelativeLayout.BELOW, itemView.getId());
						childLay.addRule(RelativeLayout.ALIGN_RIGHT, itemView.getId());
						childLay.addRule(RelativeLayout.ALIGN_LEFT, itemView.getId());
						RelativeLayout child = new RelativeLayout(parent.getContext());
						child.setVisibility(View.GONE);
						child.setId(++viewId);
						parent.addView(child, childLay);

						button.setOnClickListener((View v) -> {
							if (child.getVisibility() == View.GONE) {
								child.setVisibility(View.VISIBLE);
								button.setText("-");
							} else {
								child.setVisibility(View.GONE);
								button.setText("+");
							}
						});

						addItems(item.getChildren(), child);

						lastView = child.getId();
					}
				}
			}
		};
	}

	@Override
	RelativeLayout buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new RelativeLayout(context) : new RelativeLayout(context, null, styleResource);
	}
}
