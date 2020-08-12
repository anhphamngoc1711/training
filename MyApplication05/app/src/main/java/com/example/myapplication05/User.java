package com.example.myapplication05;

public class User {
    private Integer avatar;
    private String name;
    private String phone;

    public User(Integer avatar, String name, String phone) {
        this.avatar = avatar;
        this.name = name;
        this.phone = phone;
    }

    public User() {
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
