package com.example.main_application_demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "encode", url = "localhost:8082")
public interface EncodeFeignClient {
    @PostMapping("/encode")
    String getEncode(@RequestHeader("encode") String encode, @RequestBody String source);
}
