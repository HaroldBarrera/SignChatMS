package com.usbbog.SignchatMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.usbbog.SignchatMS.models")
public class SignchatMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignchatMsApplication.class, args);
	}

}
