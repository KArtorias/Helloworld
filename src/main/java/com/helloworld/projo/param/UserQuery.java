package com.helloworld.projo.param;

import lombok.Data;

@Data
public class UserQuery {
    private int offset = 0;
    private int limit = 10;
    private String name;

    public UserQuery(){}
    public UserQuery(int offset,int limit, String name){
        this.limit = limit;
        this.offset = offset;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }
}
