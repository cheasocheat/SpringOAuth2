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

    protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
    protected static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
    protected static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
    protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        CsrfToken token = (CsrfToken) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_NAME);
        if (token != null) {
            updateCookie(httpServletRequest, httpServletResponse, RESPONSE_TOKEN_NAME, token.getToken());
            updateCookie(httpServletRequest, httpServletResponse, RESPONSE_HEADER_NAME, token.getHeaderName());
            updateCookie(httpServletRequest, httpServletResponse, RESPONSE_PARAM_NAME, token.getParameterName());
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
