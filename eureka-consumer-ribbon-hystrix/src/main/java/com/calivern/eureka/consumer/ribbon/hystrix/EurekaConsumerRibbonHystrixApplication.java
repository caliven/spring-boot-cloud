package com.calivern.eureka.consumer.ribbon.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
//这里我们还可以使用Spring Cloud应用中的@SpringCloudApplication注解来修饰应用主类，该注解中包含了上面我们所引用的三个注解，这也意味着一个Spring Cloud标准应用应包含服务发现以及断路器。
//@SpringCloudApplication
public class EurekaConsumerRibbonHystrixApplication {

    /**
     * 被@LoadBalanced修饰过的RestTemplate可用于调用具有负载均衡的服务
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
    }
}
