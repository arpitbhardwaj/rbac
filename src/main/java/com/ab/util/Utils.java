package com.ab.util;

import com.ab.model.ActionType;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class Utils {

    public static List<ActionType> mergeList(List<ActionType> one, List<ActionType>two) {
        Set<ActionType> mergedSet = new LinkedHashSet<>(one);
        mergedSet.addAll(two);
        List<ActionType> finalList = new ArrayList<>(mergedSet);
        return finalList;
    }

}
