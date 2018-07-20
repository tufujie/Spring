package com.jef.entity;

import java.io.Serializable;

/**
 * 用户信息
 * 以用户为核心
 * @author Jef
 * @create 2018/5/15 19:18
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8514215816882785376L;
    // Redis缓存用户key
    public static final String OBJECT_KEY = "User";

    private Long id;

    private String name;

    private String password;

    private String phone;

    private Integer age;

    private Integer permission;

    private Integer admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }
}
