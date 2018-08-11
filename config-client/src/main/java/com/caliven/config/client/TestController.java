package com.caliven.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RefreshScope，如果代码中需要动态刷新配置，在需要的类上加上该注解
//（更改配置文件后提交到git，使用curl -X POST http://localhost:8086/refresh  接口刷新配置,/refresh接口是actuator模块的接口）
@RefreshScope
@RestController
public class TestController {

    // 读取git配置文件中的属性值
    @Value("${from}")
    private String from;

    @Value("${my-name}")
    private String name;

    @Autowired
    private Environment environment;


    @GetMapping("/from1")
    public String from1() {
        return this.from + "-" + this.name;
    }

    @GetMapping("/from2")
    public String from2() {
        // 通过 Environment 获取属性
        return environment.getProperty("from", "未定义");
    }

}
