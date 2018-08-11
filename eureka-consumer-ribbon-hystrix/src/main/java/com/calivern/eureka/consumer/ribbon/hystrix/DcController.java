package com.calivern.eureka.consumer.ribbon.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }

    @GetMapping("/consumer2")
    public String dc2() {
        return consumerService.consumer2();
    }


    @Component
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer2() {
            return restTemplate.getForObject("http://eureka-client/dc2", String.class);
        }

        // 服务降级方法
        public String fallback() {
            return "fallback";
        }
    }

}