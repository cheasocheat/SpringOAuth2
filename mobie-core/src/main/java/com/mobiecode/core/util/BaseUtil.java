package com.mobiecode.core.util;

public class BaseUtil {
    private static BaseUtil instance;

    public BaseUtil() {
    }

    public static BaseUtil getInstance() {
        if (instance == null) {
            instance = new BaseUtil();
        }
        return instance;
    }
}
