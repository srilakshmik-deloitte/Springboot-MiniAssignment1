package com.example.MiniAssignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@EnableAutoConfiguration
@ComponentScan("com.example.MiniAssignment1.repository.MovieRepository")
@SpringBootApplication
public class MiniAssignment1Application {

	public static void main(String[] args) {

		SpringApplication.run(MiniAssignment1Application.class, args);
	}

}
