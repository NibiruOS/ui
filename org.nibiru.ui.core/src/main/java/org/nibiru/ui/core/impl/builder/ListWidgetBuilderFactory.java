package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget.DefaultRowTypeHandler;
import org.nibiru.ui.core.api.ListWidget.RowTypeHandler;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.impl.ListWidgetImpl;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListWidgetBuilderFactory {
    private final Provider<VerticalScrollPanelBuilder> verticalScrollPanel;
    private final Provider<AbsolutePanelBuilder> absolutePanel;

    @Inject
    public ListWidgetBuilderFactory(Provider<VerticalScrollPanelBuilder> verticalScrollPanel,
                                    Provider<AbsolutePanelBuilder> absolutePanel) {
        this.verticalScrollPanel = checkNotNull(verticalScrollPanel);
        this.absolutePanel = checkNotNull(absolutePanel);
    }

    public <ModelType, RowType extends Enum<?>, ViewType extends Widget>
    ListWidgetBuilder<ModelType, RowType, ViewType> create(Class<ModelType> modelType,
                                                           Class<RowType> rowTypeEnum,
                                                           Class<ViewType> viewType,
                                                           RowTypeHandler<RowType> rowTypeHandler) {
        return new ListWidgetBuilder<>(new ListWidgetImpl<>(rowTypeHandler,
                verticalScrollPanel,
                absolutePanel));
    }

    public <ModelType, ViewType extends Widget>
    DefaultRowTypeListWidgetBuilder<ModelType, ViewType> create(Class<ModelType> modelType,
                                                                Class<ViewType> viewType,
                                                                DefaultRowTypeHandler rowTypeHandler) {
        return new DefaultRowTypeListWidgetBuilder<>(new ListWidgetImpl<>(rowTypeHandler,
                verticalScrollPanel,
                absolutePanel));
    }
}
