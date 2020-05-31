package com.ab.repository;

import com.ab.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public interface DataRepository {
    String addUser(User user);
    Map<String, Object> getData();
    String getUserAuthKey(User user, String fileName, String actionType);
    void updateUserAuthKeySet(User user);
}
