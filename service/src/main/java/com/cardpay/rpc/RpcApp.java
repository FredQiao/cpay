package com.cardpay.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cardpay"})
@EnableJpaRepositories("com.cardpay.dao")
@EntityScan("com.cardpay.entity")
public class RpcApp {

    public static void main(String[] args){
        SpringApplication.run(RpcApp.class, args);
        System.out.println("Server start ...");
    }
}
