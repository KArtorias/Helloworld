package com.helloworld.model;

public class User {
    public int id;
    public String name;
    public String sex;
    public int age;

    public User(){}

    public User(int id, String name, String sex, int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
