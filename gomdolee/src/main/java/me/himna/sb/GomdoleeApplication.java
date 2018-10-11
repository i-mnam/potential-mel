package me.himna.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="me.himna.sb")
public class GomdoleeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GomdoleeApplication.class, args);
	}
}
