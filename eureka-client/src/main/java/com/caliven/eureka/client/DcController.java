package com.caliven.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    /**
     * DiscoveryClient接口在eureka的实现中获取到的所有服务清单
     */
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        // 获取所有在 eureka server 中注册的服务清单
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }


    @GetMapping("/dc2")
    public String dc2() throws InterruptedException {
        // 模拟网络延时，触发 Hystrix 容错机制
        Thread.sleep(1000);
        // 获取所有在 eureka server 中注册的服务清单
        String services = "Hystrix Get Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}