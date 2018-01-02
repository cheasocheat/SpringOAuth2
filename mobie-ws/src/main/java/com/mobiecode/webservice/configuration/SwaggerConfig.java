package com.mobiecode.webservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mobiecode.webservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     *
     * @return
     */
    private ApiInfo metaData() {
        Contact contact = new Contact("Chea Socheat", "https://www.facebook.com/socheat.april", "cheasocheat.km@gmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "Mobile API Document",
                "Web Service Document for mobile app",
                "1.0",
                "Terms of service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
