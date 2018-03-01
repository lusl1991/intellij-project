package com.softel.model;

import lombok.Data;

@Data
public class TbMenu {

    private Integer id;

    private String icon;

    private String title;

    private String path;

    private Integer level;

    private Integer isleaf;

    private Integer parentid;

    private Integer orderid;

    private Integer zt;

}