package com.example.first_server_05feb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class FirstServer05FebApplication {


	public static void main(String[] args) {
		SpringApplication.run(FirstServer05FebApplication.class, args);
	}

}
