package com.mobiecode.domain.util;

public enum  RecordStatus {
    PUB("PUB", "Publish"),
    DRAFT("DRAFT", "Draft"),
    UNPUB("UNPUB", "Un publish"),
    RECYC("RECYC", "Recycle");

    private String code;
    private String desc;

    RecordStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
