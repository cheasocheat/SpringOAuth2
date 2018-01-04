package com.mobiecode.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    /**
     * getPasswordEncoder
     *
     * @return
     */
    public BCryptPasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
