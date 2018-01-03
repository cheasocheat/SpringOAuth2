package com.mobiecode.webservice;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages="com.mobiecode.webservice.controller")
public class MobieWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobieWebApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }*/

    @Bean
    public PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final List<Resource> resourceLst = new ArrayList<>();
        resourceLst.add(new ClassPathResource("application.properties"));
        resourceLst.add(new ClassPathResource("application-ws.properties"));
        ppc.setLocations(resourceLst.toArray(new Resource[]{}));
        return ppc;
    }
}
