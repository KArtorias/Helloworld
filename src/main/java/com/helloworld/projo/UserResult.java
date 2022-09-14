package com.helloworld.projo;

import lombok.Data;

import java.util.List;

@Data
public class UserResult {
    private List<User> users;
    private int count;
    private int offset;
    private int limit;

    public UserResult(){}

    public UserResult(List<User> users, int count, int offset, int limit) {
        this.users = users;
        this.count = count;
        this.offset = offset;
        this.limit = limit;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
