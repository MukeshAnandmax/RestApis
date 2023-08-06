package com.practice.jbdl.RestApis;

import lombok.Data;

@Data
public class User {

    private int userId;
    private String name;
    private int age;
    private String country;
    //private String sal;

    public User(int userId, String name, int age, String country) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
