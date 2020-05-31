package com.ab.service;

import com.ab.model.Role;
import com.ab.model.User;

/**
 * @author Arpit Bhardwaj
 */
public interface RBACService {
    User searchUser(String userId);
    boolean isAuthorized(String userId, String actionType, String resourceName);
}
