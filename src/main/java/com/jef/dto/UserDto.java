package com.jef.dto;

import java.io.Serializable;

/**
 * @author Jef
 * @dater 2016-11-24 0024.
 */
public class UserDto  implements Serializable{
    private Long id;

    private String name;

    private String phone;

    private Integer age;

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
}
