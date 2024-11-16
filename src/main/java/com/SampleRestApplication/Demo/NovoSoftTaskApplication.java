package com.SampleRestApplication.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NovoSoftTaskApplication {

		public static void main(String[] args) {
			SpringApplication.run(NovoSoftTaskApplication.class, args);
		}
	}

