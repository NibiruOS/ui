package org.nibiru.ui.core.impl;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.loop.Looper;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkState;

public class RelativePanelImpl extends BaseLayoutPanel implements RelativePanel {
    private final Set<Rule> rules;
    private final List<Rule> sortedRules;
    private boolean dirty;

    @Inject
    public RelativePanelImpl(AbsolutePanel panel, Looper looper) {
        super(panel, looper);
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
        // 2nd time, to aplly using new sizes
        // TODO: This should not be necessary
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
