package com.example.main_application_demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "encode", url = "localhost:8082")
public interface EncodeFeignClient {
    @PostMapping("/encode")
    String getEncode(@RequestBody String source);
}
