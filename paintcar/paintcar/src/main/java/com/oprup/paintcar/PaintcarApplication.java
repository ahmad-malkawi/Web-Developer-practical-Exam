package com.oprup.paintcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class PaintcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaintcarApplication.class, args);
	}

}
