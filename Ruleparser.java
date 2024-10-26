package com.example.ruleengine.utils;

import com.example.ruleengine.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ruleparser {

    /**
     * Parses a rule condition string into a list of tokens.
     * Example: "age > 18 AND country == 'USA'" becomes ["age", ">", "18", "AND", "country", "==", "'USA'"]
     *
     * @param condition The condition string.
     * @return A list of tokens representing the condition.
     */
    public List<String> parseCondition(String condition) {
        List<String> tokens = new ArrayList<>();
        
        // Splitting based on spaces, this is a simplified example.
        // A more advanced parser might use regex for more complex conditions.
        for (String token : condition.split("\\s+")) {
            tokens.add(token);
        }
        
        return tokens;
    }

    /**
     * Evaluates a condition based on the provided data.
     * This is a simple implementation for illustrative purposes.
     * Example: evaluateCondition("age > 18", Map.of("age", 20)) returns true.
     *
     * @param condition The condition to evaluate.
     * @param data The data map containing key-value pairs.
     * @return The result of the evaluation.
     */
    public boolean evaluateCondition(String condition, Map<String, Object> data) {
        // Here we assume a simple condition format: "key operator value"
        String[] parts = condition.split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid condition format. Expected format: 'key operator value'");
        }

        String key = parts[0];
        String operator = parts[1];
        String value = parts[2];

        Object actualValue = data.get(key);

        if (actualValue == null) {
            return false;
        }

        switch (operator) {
            case "==":
                return actualValue.toString().equals(value);
            case "!=":
                return !actualValue.toString().equals(value);
            case ">":
                return Double.parseDouble(actualValue.toString()) > Double.parseDouble(value);
            case "<":
                return Double.parseDouble(actualValue.toString()) < Double.parseDouble(value);
            case ">=":
                return Double.parseDouble(actualValue.toString()) >= Double.parseDouble(value);
            case "<=":
                return Double.parseDouble(actualValue.toString()) <= Double.parseDouble(value);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    /**
     * Converts a condition string into a Node object.
     * Example: "type == 'discount'" becomes a Node with type "condition" and value "type == 'discount'".
     *
     * @param condition The condition string.
     * @return A Node object representing the condition.
     */
    public Node convertConditionToNode(String condition) {
        Node node = new Node();
        node.setType("condition");
        node.setValue(condition);
        return node;
    }
}
