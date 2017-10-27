package com.softel.vo;

import java.util.List;

public class SubMenu {

    private String icon;

    private String title;

    private String path;

    private List<SubMenu> subs;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubMenu> getSubs() {
        return subs;
    }

    public void setSubs(List<SubMenu> subs) {
        this.subs = subs;
    }
}
