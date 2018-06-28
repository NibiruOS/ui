package org.nibiru.ui.core.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.impl.builder.AbsolutePanelBuilder;
import org.nibiru.ui.core.impl.builder.VerticalScrollPanelBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListWidgetImpl<ModelType, RowType extends Enum<?>, ViewType extends Widget>
        extends BaseWidget
        implements ListWidget<ModelType, RowType, ViewType> {

    private final Value<List<ModelType>> value = JavaValue.of(JavaType.ofUnchecked(List.class));
    private final RowTypeHandler<RowType> rowTypeHandler;
    private final Map<RowType, RowHandler<? extends ModelType, ? extends ViewType>> rowHandlers;
    private final Map<RowType, List<ViewType>> rowPools;
    private final VerticalScrollPanel scrollPanel;
    private final AbsolutePanel panel;
    private LinkedList<ViewType> visibleRows;
    private int firstVisibleRow;

    public ListWidgetImpl(RowTypeHandler<RowType> rowTypeHandler,
                          Provider<VerticalScrollPanelBuilder> verticalScrollPanel,
                          Provider<AbsolutePanelBuilder> absolutePanel) {
        this.rowTypeHandler = checkNotNull(rowTypeHandler);
        rowHandlers = Maps.newHashMap();
        rowPools = Maps.newHashMap();
        scrollPanel = verticalScrollPanel.get()
                .style(new Style())
                .content(panel = absolutePanel.get()
                        .style(new Style())
                        .build())
                .build();
        scrollPanel.getScrollPosition()
                .addObserver(this::onLayout);
        visibleRows = Lists.newLinkedList();
        value.addObserver(this::requestLayout);
    }

    @Override
    public <RowModelType extends ModelType, RowViewType extends ViewType>
    void addRowHandler(RowType rowType, RowHandler<RowModelType, RowViewType> rowHandler) {
        rowHandlers.put(rowType, rowHandler);
    }

    @Override
    public Value<List<ModelType>> getValue() {
        return value;
    }

    @Override
    public Object asNative() {
        return scrollPanel.asNative();
    }

    @Override
    public void applyStyle() {
        scrollPanel.applyStyle();
    }

    @Override
    protected void onMeasure(MeasureSpec widthMeasureSpec,
                             MeasureSpec heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        scrollPanel.getStyle().setWidth(Size.exactly(getFullMeasuredWidth()));
        scrollPanel.getStyle().setHeight(Size.exactly(getFullMeasuredHeight()));
        measureChild(scrollPanel, MeasureSpec.exactly(getFullMeasuredWidth()),
                MeasureSpec.exactly(getFullMeasuredHeight()));
    }

    @Override
    public void layout() {
        super.layout();
        scrollPanel.layout();
    }

    @Override
    protected void onLayout() {
        List<ModelType> modelList = getValue().get();
        if (modelList != null) {
            int initialRow;
            int initialRowY = 0;
            int finalRow;
            int row = 0;
            int y = 0;
            int scrollPos = scrollPanel.getScrollPosition().get();
            int scrollEnd = scrollPos + scrollPanel.getFullMeasuredHeight();

            // Calculo alto del contenido del scroll panel
            for (int n = 0; n < modelList.size(); n++) {
                y += rowTypeHandler.getRowHeight(n);
            }
            panel.getStyle().setHeight(Size.exactly(y));
            panel.getStyle().setWidth(Size.exactly(getMeasuredWidth()));

            y = 0;

            int rowHeight;
            rowHeight = rowTypeHandler.getRowHeight(0);
            while (y + rowHeight - 1 < scrollPos) {
                y += rowHeight;
                row++;
                rowHeight = rowTypeHandler.getRowHeight(row);
            }

            initialRow = row;
            initialRowY = y;

            while (y < scrollEnd) {
                y += rowTypeHandler.getRowHeight(row);
                row++;
            }

            finalRow = row;

            int lastVisibleRow = firstVisibleRow + visibleRows.size() - 1;
            if (initialRow != firstVisibleRow || finalRow != lastVisibleRow) {
                // Remove hidden rows at the beginning
                while (firstVisibleRow < initialRow) {
                    ViewType view = visibleRows.removeFirst();
                    addToPool(rowTypeHandler.getRowType(firstVisibleRow), view);
                    panel.remove(view);
                    firstVisibleRow++;
                }

                // Remove hidden rows at the end
                while (lastVisibleRow > finalRow) {
                    ViewType view = visibleRows.removeLast();
                    panel.remove(view);
                    addToPool(rowTypeHandler.getRowType(lastVisibleRow), view);
                    lastVisibleRow--;
                }

                y = initialRowY;
                // TODO: crear estas 2 listas es poco eficiente, pensar como operar sobre una sola lista
                List<ViewType> before = Lists.newArrayList();
                List<ViewType> after = Lists.newArrayList();
                for (int n = initialRow; n <= finalRow && n < modelList.size(); n++) {
                    rowHeight = rowTypeHandler.getRowHeight(n);

                    RowType rowType = rowTypeHandler.getRowType(n);
                    // TODO: Ugly cast
                    RowHandler<ModelType, ViewType> rowHandler = (RowHandler<ModelType, ViewType>) rowHandlers.get(rowType);
                    ViewType view;
                    if (n < firstVisibleRow || n > lastVisibleRow) {
                        view = removeFromPool(rowType);
                        if (view == null) {
                            view = rowHandler.createView();
                            Style style = new Style();
                            style.setWidth(Size.MATCH_PARENT);
                            view.setStyle(style);
                        }


                        rowHandler.populateView(modelList.get(n),
                                view);

                        if (view.getFullMeasuredHeight() != rowHeight) {
                            view.getStyle().setHeight(Size.exactly(rowHeight));
                            view.measure(MeasureSpec.exactly(getFullMeasuredWidth()),
                                    MeasureSpec.exactly(rowHeight));
                            view.layout();
                        }

                        if (n < firstVisibleRow) {
                            before.add(view);
                        } else {
                            after.add(view);
                        }

                        panel.add(view);
                        panel.getPosition(view)
                                .setX(0)
                                .setY(y);
                    }

                    y += rowHeight;
                }
                visibleRows = Lists.newLinkedList(Iterables.concat(before, visibleRows, after));

                firstVisibleRow = initialRow;
            }
        }
    }

    private ViewType removeFromPool(RowType rowType) {
        List<ViewType> pool = rowPools.get(rowType);
        return pool != null && pool.size() > 0
                ? pool.remove(pool.size() - 1)
                : null;
    }

    private void addToPool(RowType rowType, ViewType view) {
        List<ViewType> pool = rowPools.get(rowType);
        if (pool == null) {
            pool = Lists.newArrayList();
            rowPools.put(rowType, pool);
        }
        pool.add(view);
    }
}