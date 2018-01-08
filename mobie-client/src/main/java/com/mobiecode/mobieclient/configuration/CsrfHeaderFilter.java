package com.mobiecode.mobieclient.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Developer : cheasocheat
 * Created on 1/8/18 13:57
 */
public class CsrfHeaderFilter extends OncePerRequestFilter {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.info("CSRF Protection");
        CsrfToken csrf = (CsrfToken) httpServletRequest.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
            updateCookie(httpServletRequest, httpServletResponse, "CSRF-TOKEN", csrf.getToken());
            updateCookie(httpServletRequest, httpServletResponse, "CSRF-HEADER", csrf.getHeaderName());
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void updateCookie(HttpServletRequest request, HttpServletResponse response,
                              String cookieName, String value) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        if (cookie == null || value != null && !value.equals(cookie.getValue())) {
            cookie = new Cookie(cookieName, value);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
    }
}
