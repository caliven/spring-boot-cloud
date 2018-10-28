package com.caliven.swagger.service;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 启用 spring4all 封装的 swagger
@EnableSwagger2Doc
@EnableEurekaClient
@SpringBootApplication
public class SwaggerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerServiceApplication.class, args);
    }

    @RestController
    class AaaController {
        @Autowired
        DiscoveryClient discoveryClient;

        @GetMapping("/service-a")
        public String dc() {
            String services = "Services: " + discoveryClient.getServices();
            System.out.println(services);
            return services;
        }
    }
}
