package com.daniel.navas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EntityScan(basePackageClasses = {TestIBMApp.class})
@SpringBootApplication
public class TestIBMApp extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(TestIBMApp.class, args);
    }
}
