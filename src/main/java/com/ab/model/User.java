package com.ab.model;

import com.ab.util.Utils;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class User {
    private String userId;
    private String userName;
    private String password;
    private Set<Role> roles;

    public User(String userName, String password) {
        userId = UUID.randomUUID().toString().replace("-","");
        this.userName = userName;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Map<String,List<ActionType>> getAllResources(){
        final Map<String, List<ActionType>> resources = new HashMap<>();
        for (Role role:
             roles) {
            final Map<String, List<ActionType>> resource = role.getResourceList();
            resource.forEach((key,value) -> resources.merge(key,value, Utils::mergeList)) ;
        }
        return resources;
    }

    public boolean addRole(Role role){
        return roles.add(role);
    }
    public boolean removeRole(Role role){
        return roles.remove(role);
    }

}
