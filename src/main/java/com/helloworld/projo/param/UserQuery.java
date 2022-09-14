package com.helloworld.projo.param;

import lombok.Data;

@Data
public class UserQuery {
    private Integer offset = 0;
    private Integer limit = 10;
    private String name;

    public UserQuery(){}
    public UserQuery(Integer offset,int limit, String name){
        this.limit = limit;
        this.offset = offset;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getName() {
        return name;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
