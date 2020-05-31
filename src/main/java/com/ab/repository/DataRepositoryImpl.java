package com.ab.repository;

import com.ab.model.ActionType;
import com.ab.model.User;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class DataRepositoryImpl implements DataRepository{

    Map<String, Object> data;

    public DataRepositoryImpl() {
        this.data = new HashMap<String, Object>();
    }

    public String addUser(User user) {
        Map<String,User> userMap = (Map<String, User>) data.get("user");
        if (userMap == null){
            userMap = new HashMap<String, User>();
            data.put("user",userMap);
        }
        userMap.put(user.getUserId(), user);
        updateUserAuthKeySet(user);
        return user.getUserId();
    }

    public void updateUserAuthKeySet(User user) {
        Set<String> authKeySet = (Set<String>) data.get("authKey");
        /*if (authKeySet == null){
            authKeySet = new HashSet<>();
            data.put("authKey",authKeySet);
        }*/

        authKeySet = new HashSet<>();
        data.put("authKey",authKeySet);

        Map<String, List<ActionType>> allResources = user.getAllResources();

        for (Map.Entry<String, List<ActionType>> resource:
             allResources.entrySet()) {
            String resourceName = resource.getKey();
            List<ActionType> actionTypes = resource.getValue();
            for (ActionType actionType:
                 actionTypes) {
                authKeySet.add(getUserAuthKey(user,resourceName,actionType.name()));
            }
        }
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getUserAuthKey(User user, String fileName, String actionType) {
        return user.getUserId()+"_"+fileName+"_"+actionType;
    }
}
