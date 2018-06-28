package org.nibiru.ui.core.api;

import java.util.List;

public interface ListWidget<ModelType, RowType extends Enum<?>, ViewType extends Widget>
        extends ValueWidget<List<ModelType>> {
    interface RowTypeHandler<RowType extends Enum<?>> {
        RowType getRowType(int row);

        int getRowHeight(int row);
    }

    enum DefaultRowType {DEFAULT_ROW_TYPE}

    interface DefaultRowTypeHandler
            extends RowTypeHandler<DefaultRowType> {
        default DefaultRowType getRowType(int row) {
            return DefaultRowType.DEFAULT_ROW_TYPE;
        }
    }

    interface RowHandler<ModelType, ViewType> {
        ViewType createView();

        void populateView(ModelType data, ViewType view);
    }

    <RowModelType extends ModelType, RowViewType extends ViewType>
    void addRowHandler(RowType rowType,
                       RowHandler<RowModelType, RowViewType> rowHandler);
}
