package org.nibiru.ui.core.impl;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.loop.Looper;
import org.nibiru.ui.core.impl.rule.AboveRule;
import org.nibiru.ui.core.impl.rule.AlignBottomRule;
import org.nibiru.ui.core.impl.rule.AlignLeftRule;
import org.nibiru.ui.core.impl.rule.AlignRightRule;
import org.nibiru.ui.core.impl.rule.AlignTopRule;
import org.nibiru.ui.core.impl.rule.BelowRule;
import org.nibiru.ui.core.impl.rule.CenterHorizontallyRule;
import org.nibiru.ui.core.impl.rule.CenterVerticallyRule;
import org.nibiru.ui.core.impl.rule.MatchBottomRule;
import org.nibiru.ui.core.impl.rule.MatchHeightRule;
import org.nibiru.ui.core.impl.rule.MatchRightRule;
import org.nibiru.ui.core.impl.rule.MatchWidthRule;
import org.nibiru.ui.core.impl.rule.ToLeftOfRule;
import org.nibiru.ui.core.impl.rule.ToRightOfRule;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkState;

public class RelativePanelImpl extends BaseLayoutPanel implements RelativePanel {
    private final Set<Rule> rules;
    private final List<Rule> sortedRules;
    private boolean dirty;

    @Inject
    public RelativePanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
        super(panel, viewport, looper);
        this.rules = Sets.newHashSet();
        this.sortedRules = Lists.newArrayList();
    }

    @Override
    public void addRule(Rule rule) {
        dirty = true;
        rules.add(rule);
    }

    @Override
    public AbsolutePanel getContainer() {
        return panel;
    }

    @Override
    public void addAbove(Widget target, @Nullable Widget source, int margin) {
        addRule(new AboveRule(target, source, this, margin));
    }

    @Override
    public void addAlignBottom(Widget target, @Nullable Widget source, int margin) {
        addRule(new AlignBottomRule(target, source, this, margin));
    }

    @Override
    public void addAlignLeft(Widget target, @Nullable Widget source, int margin) {
        addRule(new AlignLeftRule(target, source, this, margin));
    }

    @Override
    public void addAlignRight(Widget target, @Nullable Widget source, int margin) {
        addRule(new AlignRightRule(target, source, this, margin));
    }

    @Override
    public void addAlignTop(Widget target, @Nullable Widget source, int margin) {
        addRule(new AlignTopRule(target, source, this, margin));
    }

    @Override
    public void addBelow(Widget target, @Nullable Widget source, int margin) {
        addRule(new BelowRule(target, source, this, margin));
    }

    @Override
    public void addCenterHorizontally(Widget target, @Nullable Widget source, int margin) {
        addRule(new CenterHorizontallyRule(target, source, this, margin));
    }

    @Override
    public void addCenterVertically(Widget target, @Nullable Widget source, int margin) {
        addRule(new CenterVerticallyRule(target, source, this, margin));
    }

    @Override
    public void addMatchBottom(Widget target, @Nullable Widget source, int margin) {
        addRule(new MatchBottomRule(target, source, this, margin));
    }

    @Override
    public void addMatchHeight(Widget target, @Nullable Widget source, int margin) {
        addRule(new MatchHeightRule(target, source, this, margin));
    }

    @Override
    public void addMatchRight(Widget target, @Nullable Widget source, int margin) {
        addRule(new MatchRightRule(target, source, this, margin));
    }

    @Override
    public void addMatchWidth(Widget target, @Nullable Widget source, int margin) {
        addRule(new MatchWidthRule(target, source, this, margin));
    }

    @Override
    public void addToLeftOf(Widget target, @Nullable Widget source, int margin) {
        addRule(new ToLeftOfRule(target, source, this, margin));
    }

    @Override
    public void addToRightOf(Widget target, @Nullable Widget source, int margin) {
        addRule(new ToRightOfRule(target, source, this, margin));
    }


    @Override
    public void requestLayout() {
        if (dirty) {
            performTopologicalSort();
            dirty = false;
        }
        super.requestLayout();
    }

    @Override
    protected void onMeasure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
        for (Widget child : getChildren()) {
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
        applyRulesAndUpdatesize(widthMeasureSpec, heightMeasureSpec);
    }

    private void applyRulesAndUpdatesize(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
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
                maxWidth = Math.max(maxWidth, widthMeasureSpec.getValue());
                break;
            case UNSPECIFIED:
                break;
            default:
                throw new IllegalArgumentException("Invalid widthmesaure type:" + widthMeasureSpec.getType());
        }
        switch (heightMeasureSpec.getType()) {
            case EXACTLY:
                maxHeight = heightMeasureSpec.getValue();
                break;
            case AT_MOST:
                maxHeight = Math.max(maxHeight, heightMeasureSpec.getValue());
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
        super.onLayout();
        for (Widget child : getChildren()) {
            child.layout();
        }
    }

    private void performTopologicalSort() {
        Multimap<VertexKey, Node> dependantNodes = HashMultimap.create();
        Set<Node> nodes = Sets.newHashSet();
        for (Rule rule : rules) {
            Node node = new Node(rule);
            nodes.add(node);
            for (VertexKey vertex : rule.getSource()) {
                dependantNodes.put(vertex, node);
            }
        }
        for (Node sourceNode : nodes) {
            for (VertexKey target :sourceNode.rule.getTarget()) {
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
        while (!removalQueue.isEmpty()) {
            Node node = removalQueue.remove();
            sortedRules.add(node.rule);
            for (Node dependant : node.outputVertexs) {
                dependant.inputVertexCount--;
                if (dependant.inputVertexCount == 0) {
                    removalQueue.add(dependant);
                }
            }
        }
        checkState(sortedRules.size() == rules.size(), "Cycle detected in rules definition.");
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
