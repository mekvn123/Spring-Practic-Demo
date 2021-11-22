package com.example.figen_client.adapter.rest;

import com.example.figen_client.exception.EncodeNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class EncodeController {
    @PostMapping("/encode")
    public String getEncode(@RequestHeader("encode") String encode, @RequestBody String source) {
        String encodeSource = "";
        switch (encode) {
            case "Base64":
                encodeSource = Base64.getEncoder().encodeToString(source.getBytes(StandardCharsets.UTF_8));
                break;
            case "JWT":
                break;
            default:
                throw new EncodeNotFoundException();
        }
        return encodeSource;
    }
}
