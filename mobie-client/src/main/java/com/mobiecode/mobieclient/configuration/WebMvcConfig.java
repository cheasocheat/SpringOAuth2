package com.mobiecode.mobieclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import(ApplicationSecurity.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SecurityExpressionHandler<FilterInvocation> securityExpressionHandler() {
        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setDefaultRolePrefix("");
        return defaultWebSecurityExpressionHandler;
    }

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }*/



}
