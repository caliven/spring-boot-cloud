package com.caliven.eureka.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * eureka-consumer-feign 文件上传
 */
@RestController
public class UploadController {

    @PostMapping(value = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart("file") MultipartFile file) {
        System.out.println("=========" + file.getOriginalFilename());
        return file.getOriginalFilename();
    }

}