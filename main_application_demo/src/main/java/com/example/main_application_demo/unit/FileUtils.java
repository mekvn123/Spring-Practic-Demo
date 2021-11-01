package com.example.main_application_demo.unit;

import lombok.SneakyThrows;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

public class FileUtils {
    @SneakyThrows
    public static String loadTestSuiteResource(String filename) {
        return StreamUtils.copyToString(FileUtils.class.getResourceAsStream(
                        String.format("/json/%s", filename)),
                Charset.defaultCharset()
        );
    }
}
