package com.yyhn.exam.vo;

import java.io.Serializable;

public class SysRoleSearchVO implements Serializable {

    private String tag;

    private String name;

    private String url;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
