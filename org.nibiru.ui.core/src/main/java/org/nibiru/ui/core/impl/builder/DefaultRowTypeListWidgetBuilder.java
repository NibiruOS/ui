package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.ListWidget.DefaultRowType;
import org.nibiru.ui.core.api.ListWidget.RowHandler;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

public class DefaultRowTypeListWidgetBuilder<ModelType, ViewType extends Widget>
        extends BaseBuilder<ListWidget<ModelType, DefaultRowType, ViewType>>
        implements WidgetBuilder<ListWidget<ModelType, DefaultRowType, ViewType>,
        DefaultRowTypeListWidgetBuilder<ModelType, ViewType>>,
        ValueWidgetBuilder<ListWidget<ModelType, DefaultRowType, ViewType>,
                List<ModelType>,
                DefaultRowTypeListWidgetBuilder<ModelType, ViewType>> {

    public DefaultRowTypeListWidgetBuilder(ListWidget<ModelType, DefaultRowType, ViewType> control) {
        super(control);
    }

    public <RowViewType extends ViewType>
    DefaultRowTypeListWidgetBuilder<ModelType, ViewType> rowHandler(RowHandler<ModelType, RowViewType> rowHandler) {
        object.addRowHandler(DefaultRowType.DEFAULT_ROW_TYPE, rowHandler);
        return this;
    }
}