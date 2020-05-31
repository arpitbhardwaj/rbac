package com.ab.service;

import com.ab.model.Role;
import com.ab.model.User;
import com.ab.repository.DataRepository;

import java.util.Map;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class RBACServiceImpl implements RBACService {

    private DataRepository dataRepository;

    public RBACServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public User searchUser(String userId) {
        Map<String, User> userMap = (Map<String, User>) dataRepository.getData().get("user");
        if (userMap.containsKey(userId)){
            return userMap.get(userId);
        }else {
            throw new IllegalArgumentException("You are not an authorized user!!");
        }
    }

    @Override
    public boolean addRole(String userId, Role role) {
        User user = searchUser(userId);
        boolean added = user.addRole(role);
        dataRepository.updateUserAuthKeySet(user);
        return added;
    }

    @Override
    public boolean removeRole(String userId,Role role) {
        User user = searchUser(userId);
        boolean removed = user.removeRole(role);
        dataRepository.updateUserAuthKeySet(user);
        return removed;
    }

    public boolean isAuthorized(String userId, String actionType, String resourceName) {
        User user = searchUser(userId);
        Set<String> authKeySet = (Set<String>) dataRepository.getData().get("authKey");
        return authKeySet.contains(dataRepository.getUserAuthKey(user,resourceName,actionType));
    }
}
