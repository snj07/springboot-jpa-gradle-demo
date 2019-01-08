package com.snj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.snj")
public class SwaggerConfig {



    /**
     * @return Docket
     */
    @Bean
    public Docket productApi() {


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());


    }
//    @Bean
//    SecurityConfiguration security() {
//
//        return new SecurityConfiguration(
//                "client",
//                "secret",
//                "",
//                "",
//                "{{X-XSRF-COOKIE}}",
//                ApiKeyVehicle.HEADER,
//                "X-XSRF-TOKEN",
//                "" /*scope separator*/);
//    }


    /**
     * @return ApiInf
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Authentication API").description("")
                .termsOfServiceUrl("https://www.example.com/api")
                .contact(new Contact("Developers", "https://projects.spring.io/spring-boot/", ""))
                .license("Open Source")
                .licenseUrl("\"https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }

}
