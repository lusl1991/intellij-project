package com.softel.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Student {
    private Integer id;

    private String name;

    private Boolean sex;

    /**
     * 当为null或者""时，不返回该字段
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}