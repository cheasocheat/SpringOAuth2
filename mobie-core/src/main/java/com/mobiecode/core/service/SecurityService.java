package com.mobiecode.core.service;

/**
 * Developer : cheasocheat
 * Created on 1/4/18 22:49
 */
public interface SecurityService {
    /**
     * findLoggedInUsername
     * @return
     */
    String findLoggedInUsername();

    /**
     * autologin
     * @param username
     * @param password
     */
    void autologin(String username, String password);
}
