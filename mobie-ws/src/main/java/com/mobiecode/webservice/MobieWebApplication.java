package com.mobiecode.webservice;

import com.mobiecode.domain.configuration.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
//@ComponentScan(basePackages="com.mobiecode.webservice.controller")
public class MobieWebApplication {

    @Autowired
    private DatabaseConfig databaseConfig;

    public static void main(String[] args) {
        SpringApplication.run(MobieWebApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }*/

    /*@Bean
    public PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final List<Resource> resourceLst = new ArrayList<>();
        resourceLst.add(new ClassPathResource("application.properties"));
        resourceLst.add(new ClassPathResource("application-ws.properties"));
        ppc.setLocations(resourceLst.toArray(new Resource[]{}));
        return ppc;
    }*/
}
