package com.jef.entity;

import java.io.Serializable;

/**
 * 基金
 * @author Jef
 * @date 2020/2/18
 */
public class Foundation implements Serializable {

    private static final long serialVersionUID = 7646198771535848765L;

    /**
     * 基金编码
     */
    private String code;
    /**
     * 基金名称
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}