package com.amsidh.mvc;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.amsidh.mvc"})
@EnableAdminServer
public class SpringbootAdminUI {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminUI.class, args);
    }

}