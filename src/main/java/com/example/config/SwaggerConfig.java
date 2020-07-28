package com.example.config;

import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * Configures Swagger framework to provide personalised behaviour.
 */
@Configuration
@Slf4j
public class SwaggerConfig {

    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.maintainer}")
    private String appMaintainer;

    @Value("${app.maintainerUrl}")
    private String appMaintainerUrl;

    @Value("${app.maintainerEmail}")
    private String appMaintainerEmail;


    private static final String BASE_PACKAGE = "com.example";

    @Bean
    public Docket swaggerApi() {

        log.info("Using Swagger for controller under package: ", BASE_PACKAGE);

        Contact contact = new Contact(appMaintainer, appMaintainerUrl, appMaintainerEmail);

        ApiInfo apiInfo = new ApiInfo(appName, appDescription, appVersion, null, contact, null, null);

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .build()
                .apiInfo(apiInfo);
    }
}
