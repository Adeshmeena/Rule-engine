package com.example.ruleengine.Service;

import com.example.ruleengine.model.Node;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RuleService {
    public Node combineNodes(Node node1, Node node2) {
        Node combinedNode = new Node();
        combinedNode.setType(node1.getType() + "-" + node2.getType());
        combinedNode.setValue(node1.getValue() + " & " + node2.getValue());
        return combinedNode;
    }

    public boolean evaluateRule(Node rule, Map<String, Object> data) {
        // Example logic for rule evaluation
        return data.containsKey(rule.getValue());
    }

    @Override
    public String toString() {
        return "RuleService []";
    }
}
