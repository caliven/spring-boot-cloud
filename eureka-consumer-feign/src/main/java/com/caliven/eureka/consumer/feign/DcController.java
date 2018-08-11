package com.caliven.eureka.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DcController {

    @Autowired
    DcClient dcClient;
    @Autowired
    UploadService uploadService;


    @GetMapping("/consumer")
    public String consumer() {
        /**
         * 通过定义的feign客户端来调用服务提供方的接口
         */
        return dcClient.consumer();
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) {
        return uploadService.handleFileUpload(file);
    }
}