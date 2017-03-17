package com.caliven;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Caliven on 2017/3/17.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

}
