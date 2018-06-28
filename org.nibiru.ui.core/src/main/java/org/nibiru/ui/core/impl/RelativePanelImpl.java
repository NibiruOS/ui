package org.nibiru.ui.core.impl;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.impl.rule.AboveRule;
import org.nibiru.ui.core.impl.rule.AlignBottomRule;
import org.nibiru.ui.core.impl.rule.AlignLeftRule;
import org.nibiru.ui.core.impl.rule.AlignRightRule;
import org.nibiru.ui.core.impl.rule.AlignTopRule;
import org.nibiru.ui.core.impl.rule.BelowRule;
import org.nibiru.ui.core.impl.rule.CenterHorizontallyRule;
import org.nibiru.ui.core.impl.rule.CenterVerticallyRule;
import org.nibiru.ui.core.impl.rule.MatchBottomWithBottomRule;
import org.nibiru.ui.core.impl.rule.MatchBottomWithTopRule;
import org.nibiru.ui.core.impl.rule.MatchHeightRule;
import org.nibiru.ui.core.impl.rule.MatchLeftWithLeftRule;
import org.nibiru.ui.core.impl.rule.MatchLeftWithRightRule;
import org.nibiru.ui.core.impl.rule.MatchRightWithLeftRule;
import org.nibiru.ui.core.impl.rule.MatchRightWithRightRule;
import org.nibiru.ui.core.impl.rule.MatchTopWithBottomRule;
import org.nibiru.ui.core.impl.rule.MatchTopWithTopRule;
import org.nibiru.ui.core.impl.rule.MatchWidthRule;
import org.nibiru.ui.core.impl.rule.ToLeftOfRule;
import org.nibiru.ui.core.impl.rule.ToRightOfRule;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkState;

public class RelativePanelImpl extends BaseLayoutPanel implements RelativePanel {
    private final Set<Rule> rules;
    private final List<Rule> sortedRules;
    private final Map<Widget, Integer> widths;
    private final Map<Widget, Integer> heights;
    private boolean areRulesDirty;

    @Inject
    public RelativePanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
        super(panel, viewport, looper);
        rules = Sets.newLinkedHashSet();
        sortedRules = Lists.newArrayList();
        widths = Maps.newHashMap();
        heights = Maps.newHashMap();
    }

    @Override
    public void add(Widget child) {
        super.add(child);
    }

    @Override
    public void addRule(Rule rule) {
        areRulesDirty = true;
        rules.add(rule);
    }

    @Override
    public AbsolutePanel getContainer() {
        return panel;
    }

    @Override
    public void setHeight(Widget target, int height) {
        heights.put(target, height);
    }

    @Override
    public void setWidth(Widget target, int width) {
        widths.put(target, width);
    }

    @Override
    public void addAbove(Widget target, @Nullable Widget source) {
        addRule(new AboveRule(target, source, this));
    }

    @Override
    public void addAlignBottom(Widget target, @Nullable Widget source) {
        addRule(new AlignBottomRule(target, source, this));
    }

    @Override
    public void addAlignLeft(Widget target, @Nullable Widget source) {
        addRule(new AlignLeftRule(target, source, this));
    }

    @Override
    public void addAlignRight(Widget target, @Nullable Widget source) {
        addRule(new AlignRightRule(target, source, this));
    }

    @Override
    public void addAlignTop(Widget target, @Nullable Widget source) {
        addRule(new AlignTopRule(target, source, this));
    }

    @Override
    public void addBelow(Widget target, @Nullable Widget source) {
        addRule(new BelowRule(target, source, this));
    }

    @Override
    public void addCenterHorizontally(Widget target, @Nullable Widget source) {
        addRule(new CenterHorizontallyRule(target, source, this));
    }

    @Override
    public void addCenterVertically(Widget target, @Nullable Widget source) {
        addRule(new CenterVerticallyRule(target, source, this));
    }

    @Override
    public void addMatchBottomWithBottom(Widget target, @Nullable Widget source) {
        addRule(new MatchBottomWithBottomRule(target, source, this));
    }

    @Override
    public void addMatchBottomWithTop(Widget target, @Nullable Widget source) {
        addRule(new MatchBottomWithTopRule(target, source, this));
    }

    @Override
    public void addMatchHeight(Widget target, @Nullable Widget source) {
        addRule(new MatchHeightRule(target, source, this));
    }

    @Override
    public void addMatchLeftWithLeft(Widget target, @Nullable Widget source) {
        addRule(new MatchLeftWithLeftRule(target, source, this));
    }

    @Override
    public void addMatchLeftWithRight(Widget target, @Nullable Widget source) {
        addRule(new MatchLeftWithRightRule(target, source, this));
    }

    @Override
    public void addMatchRightWithLeft(Widget target, @Nullable Widget source) {
        addRule(new MatchRightWithLeftRule(target, source, this));
    }

    @Override
    public void addMatchRightWithRight(Widget target, @Nullable Widget source) {
        addRule(new MatchRightWithRightRule(target, source, this));
    }

    @Override
    public void addMatchTopWithBottom(Widget target, @Nullable Widget source) {
        addRule(new MatchTopWithBottomRule(target, source, this));
    }

    @Override
    public void addMatchTopWithTop(Widget target, @Nullable Widget source) {
        addRule(new MatchTopWithTopRule(target, source, this));
    }

    @Override
    public void addMatchWidth(Widget target, @Nullable Widget source) {
        addRule(new MatchWidthRule(target, source, this));
    }

    @Override
    public void addToLeftOf(Widget target, @Nullable Widget source) {
        addRule(new ToLeftOfRule(target, source, this));
    }

    @Override
    public void addToRightOf(Widget target, @Nullable Widget source) {
        addRule(new ToRightOfRule(target, source, this));
    }

    @Override
    protected void onMeasure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        widths.clear();
        heights.clear();
        for (Widget child : getChildren()) {
            getContainer().getPosition(child).setX(0).setY(0);
        }
        if (areRulesDirty) {
            performTopologicalSort();
        }
        for (int n = 0; n < 2; n++) { //TODO: Why 2 times?
            applyRulesAndUpdateSize(widthMeasureSpec, heightMeasureSpec);
            for (Widget child : getChildren()) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    protected void measureChild(Widget child, MeasureSpec parentWidthMeasureSpec,
                                MeasureSpec parentHeightMeasureSpec) {

        Integer width = widths.get(child);
        MeasureSpec childWidthMeasureSpec = width != null
                ? MeasureSpec.exactly(width)
                : getChildMeasureSpec(parentWidthMeasureSpec, child.getStyle().getWidth());
        Integer height = heights.get(child);
        MeasureSpec childHeightMeasureSpec = height != null
                ? MeasureSpec.exactly(height)
                : getChildMeasureSpec(parentHeightMeasureSpec, child.getStyle().getHeight());

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }


    private void applyRulesAndUpdateSize(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        for (Rule rule : sortedRules) {
            rule.apply();
        }
        int maxWidth = 0;
        int maxHeight = 0;
        for (Widget child : getChildren()) {
            AbsolutePanel.Position pos = panel.getPosition(child);
            int width = pos.getX() + child.getMeasuredWidth();
            if (width > maxWidth) {
                maxWidth = width;
            }
            int height = pos.getY() + child.getMeasuredHeight();
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        switch (widthMeasureSpec.getType()) {
            case EXACTLY:
                maxWidth = widthMeasureSpec.getValue();
                break;
            case AT_MOST:
                if(getStyle().getWidth().equals(Size.MATCH_PARENT)) {
                    maxWidth = widthMeasureSpec.getValue();
                }
                break;
            case UNSPECIFIED:
                break;
            default:
                throw new IllegalArgumentException("Invalid width mesaure type:" + widthMeasureSpec.getType());
        }
        switch (heightMeasureSpec.getType()) {
            case EXACTLY:
                maxHeight = heightMeasureSpec.getValue();
                break;
            case AT_MOST:
                if (getStyle().getHeight().equals(Size.MATCH_PARENT)) {
                    maxHeight = heightMeasureSpec.getValue();
                }
                break;
            case UNSPECIFIED:
                break;
            default:
                throw new IllegalArgumentException("Invalid height mesaure type:" + heightMeasureSpec.getType());
        }
        updateSize(maxWidth, maxHeight);
    }

    @Override
    public void onLayout() {
        for (Widget child : getChildren()) {
            child.layout();
        }
        super.onLayout();
    }

    private void performTopologicalSort() {
        Multimap<VertexKey, Node> dependantNodes = HashMultimap.create();
        Set<Node> nodes = Sets.newLinkedHashSet();
        for (Rule rule : rules) {
            Node node = new Node(rule);
            nodes.add(node);
            for (VertexKey vertex : rule.getSource()) {
                dependantNodes.put(vertex, node);
            }
        }
        for (Node sourceNode : nodes) {
            for (VertexKey target : sourceNode.rule.getTarget()) {
                for (Node targetNode : dependantNodes.get(target)) {
                    sourceNode.addOutputVertex(targetNode);
                }
            }
        }

        Queue<Node> removalQueue = Queues.newArrayDeque();
        for (Node node : nodes) {
            if (node.inputVertexCount == 0) {
                removalQueue.add(node);
            }
        }
        sortedRules.clear();
        while (!nodes.isEmpty()) {
            while (!removalQueue.isEmpty()) {
                Node node = removalQueue.remove();
                nodes.remove(node);
                sortedRules.add(node.rule);
                for (Node dependant : node.outputVertexs) {
                    dependant.inputVertexCount--;
                    if (dependant.inputVertexCount == 0 && nodes.contains(dependant)) {
                        removalQueue.add(dependant);
                    }
                }
            }
            if (!nodes.isEmpty()) {
                removalQueue.add(nodes.iterator().next());
            }
        }
        checkState(sortedRules.size() == rules.size(), "Unresolved cycle detected in rules definition.");
        areRulesDirty = false;
    }

    private class Node {
        private final Rule rule;
        private Collection<Node> outputVertexs;
        private int inputVertexCount;

        private Node(Rule rule) {
            this.rule = rule;
            outputVertexs = Lists.newArrayList();
        }

        private void addOutputVertex(Node target) {
            outputVertexs.add(target);
            target.inputVertexCount++;
        }
    }
}
