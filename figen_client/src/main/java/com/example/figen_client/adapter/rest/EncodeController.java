package com.example.figen_client.adapter.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncodeController {
    @PostMapping("/encode")
    public String getEncode(@RequestBody String source) {
        return source.concat("encode");
    }
}
