package com.upc.ShowTimeBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShowTimeBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowTimeBdApplication.class, args);
	}

}
