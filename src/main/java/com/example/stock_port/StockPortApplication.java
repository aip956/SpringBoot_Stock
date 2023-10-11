package com.example.stock_port;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.stock_port")
public class StockPortApplication {

    public static void main(String[] args) {

        SpringApplication.run(StockPortApplication.class, args);
        System.out.println("Hello there!");
    }

}
