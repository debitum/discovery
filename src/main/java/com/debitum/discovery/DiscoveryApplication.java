package com.debitum.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


@EnableEurekaServer
@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
public class DiscoveryApplication {

    public static final String LOCAL_PROFILE = "local";

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DiscoveryApplication.class);
        addDefaultProfile();
        app.run(args);
    }

    private static void addDefaultProfile() {
        if (LOCAL_PROFILE.equals(System.getProperty("spring.profiles.active"))) {
            System.setProperty("spring.cloud.bootstrap.enabled", "false");
        }
    }
}
