package com.ab.model;

import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class Role {
    private Map<String, List<ActionType>> resourceList;

    public Map<String, List<ActionType>> getResourceList() {
        return resourceList;
    }

    public void setResourceList(Map<String, List<ActionType>> resourceList) {
        this.resourceList = resourceList;
    }

}
