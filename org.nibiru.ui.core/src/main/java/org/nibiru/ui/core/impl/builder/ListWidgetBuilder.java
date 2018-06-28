package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.ListWidget.RowHandler;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import javax.inject.Inject;

public class ListWidgetBuilder<ModelType, RowType extends Enum<?>, ViewType extends Widget>
        extends BaseBuilder<ListWidget<ModelType, RowType, ViewType>>
        implements WidgetBuilder<ListWidget<ModelType, RowType, ViewType>,
        ListWidgetBuilder<ModelType, RowType, ViewType>>,
        ValueWidgetBuilder<ListWidget<ModelType, RowType, ViewType>,
                List<ModelType>,
                ListWidgetBuilder<ModelType, RowType, ViewType>> {

    public ListWidgetBuilder(ListWidget<ModelType, RowType, ViewType> control) {
        super(control);
    }

    public <RowModelType extends ModelType,
            RowViewType extends ViewType>
    ListWidgetBuilder<ModelType, RowType, ViewType> rowHandler(RowType rowType,
                                                               RowHandler<RowModelType, RowViewType> rowHandler) {
        object.addRowHandler(rowType, rowHandler);
        return this;
    }
}
