package com.mobiecode.mobieclient.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Developer : cheasocheat
 * Created on 1/5/18 14:59
 */
@Component
public class LogoutSucessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    //    @Autowired
//    private AuditService auditService;
    public LogoutSucessHandler() {
        super();
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String refererUrl = httpServletRequest.getHeader("Referer");
//        auditService.track("Logout from: " + refererUrl);
        logger.debug("Logout from: "+refererUrl);
        super.onLogoutSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}
