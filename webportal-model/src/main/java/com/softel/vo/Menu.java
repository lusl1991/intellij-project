package com.softel.vo;

import java.util.List;

public class Menu {

    private Integer id;

    private String icon;

    private String title;

    private List<SubMenu> subs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubMenu> getSubs() {
        return subs;
    }

    public void setSubs(List<SubMenu> subs) {
        this.subs = subs;
    }
}
