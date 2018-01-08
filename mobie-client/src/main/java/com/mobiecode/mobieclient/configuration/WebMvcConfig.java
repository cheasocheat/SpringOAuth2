package com.mobiecode.mobieclient.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*@EnableWebMvc*/
@Configuration
@Import(SecurityConfiguration.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }*/

}
