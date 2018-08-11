
package com.caliven.eureka.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 创建一个Feign的客户端接口定义。使用@FeignClient注解来指定这个接口所要调用的服务名称
 */
@FeignClient("eureka-client")
public interface DcClient {


    /**
     * 绑定eureka-client服务的/dc接口
     *
     * @return
     */
    @GetMapping("/dc")
    String consumer();

}

