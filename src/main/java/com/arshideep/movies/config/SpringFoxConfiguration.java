package com.arshideep.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.arshideep.movies"))
                .paths(PathSelectors.ant("/api/**")).build().apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Movie Reservation API","Sample API ","1.0","Free to Use",new Contact("Richa Luthra","","richaluthra.ca@gmail.com"),"API License","LicenseUrl", Collections.emptyList());
    }
}
