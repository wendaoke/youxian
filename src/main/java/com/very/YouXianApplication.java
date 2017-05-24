package com.very;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class YouXianApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouXianApplication.class, args);
	}

}
