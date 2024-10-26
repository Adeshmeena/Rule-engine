package com.example.ruleengine.model;

import com.example.ruleengine.controller.PostMapping;
import com.example.ruleengine.controller.Rulecontroller;

public class Node {
    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Endpoint to combine rules.
     *
     * @param rulecontroller TODO
     * @return The combined rule as a string.
     */
    @PostMapping("/combine")
    public String combineRules(Rulecontroller rulecontroller) {
        return rulecontroller.ruleService.combineRules(this);
    }
}
