package com.mobiecode.core.util;

/**
 * Developer : cheasocheat
 * Created on 1/8/18 13:15
 */
public enum UserRole {
    ADM("ADM", "Admin"),
    EPR("EPR", "Event Planner"),
    NUS("NUS", "Normal User");

    private String code;
    private String desc;

    UserRole(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
