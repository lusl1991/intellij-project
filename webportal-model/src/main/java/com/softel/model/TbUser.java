package com.softel.model;

import lombok.Data;

@Data
public class TbUser {
    private Integer id;

    private String name;

    private Boolean sex;

    private String account;

    private String password;

}