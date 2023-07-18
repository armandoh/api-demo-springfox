package com.epam.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
public class SwaggerConfig {
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Phone Service API")
                .description("This service is used to manage phones")
                .build();
    }
}