package com.test.zx.test;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String userId;
    protected List<String> groups = new ArrayList<String>();



    public User() {
    }


    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}
