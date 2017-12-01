package com.cardpay.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcApp {

    public static void main(String[] args){
        SpringApplication.run(RpcApp.class, args);
        System.out.println("Server start ...");
    }
}
