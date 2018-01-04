package com.mobiecode.webservice;

import com.mobiecode.core.CoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreApplication.class)
public class MobieWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobieWebApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }*/
}
