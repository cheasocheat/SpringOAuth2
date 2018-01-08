package com.mobiecode.core.util;

import org.springframework.security.core.GrantedAuthority;

/**
 * Developer : cheasocheat
 * Created on 1/8/18 13:13
 */
public class ProfileUtil {

    /**
     *
     * @param grantedAuthority
     * @return
     */
    public static boolean isAdminProfile(GrantedAuthority grantedAuthority){
        return grantedAuthority.getAuthority().equals(UserRole.ADM.getCode());
    }

    /**
     * isEventPlannerProfile
     * @param grantedAuthority
     * @return
     */
    public static boolean isEventPlannerProfile(GrantedAuthority grantedAuthority){
        return grantedAuthority.getAuthority().equals(UserRole.EPR.getCode());
    }

    /**
     * isNormalUserProfile
     * @param grantedAuthority
     * @return
     */
    public static boolean isNormalUserProfile(GrantedAuthority grantedAuthority){
        return grantedAuthority.getAuthority().equals(UserRole.NUS.getCode());
    }
}
