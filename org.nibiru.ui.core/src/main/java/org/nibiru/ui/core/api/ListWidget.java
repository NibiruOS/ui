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

    interface RowViewCreator<ViewType> {
        ViewType createView();
    }

    interface RowViewPopulator<ModelType, ViewType> {
        void populateView(ModelType data, ViewType view);
    }

    interface RowHandler<ModelType, ViewType>
            extends RowViewCreator<ViewType>,
            RowViewPopulator<ModelType, ViewType> {
    }

    <RowModelType extends ModelType, RowViewType extends ViewType>
    void addRowHandler(RowType rowType,
                       RowHandler<RowModelType, RowViewType> rowHandler);


    default <RowModelType extends ModelType, RowViewType extends ViewType>
    void addRowHandler(RowType rowType,
                       RowViewCreator<RowViewType> rowViewCreator,
                       RowViewPopulator<RowModelType, RowViewType> rowViewPopulator) {
        addRowHandler(rowType,
                new RowHandler<RowModelType, RowViewType>() {
                    @Override
                    public RowViewType createView() {
                        return rowViewCreator.createView();
                    }

                    @Override
                    public void populateView(RowModelType data, RowViewType view) {
                        rowViewPopulator.populateView(data, view);
                    }
                });
    }
}
