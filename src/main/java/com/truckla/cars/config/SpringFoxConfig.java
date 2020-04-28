package com.truckla.cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {


    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Car fleet management API")
                .description("The API allows you to manage the car fleet, add repairs and view statistics.")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.truckla.cars"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}