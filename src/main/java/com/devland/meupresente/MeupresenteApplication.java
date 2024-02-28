package com.devland.meupresente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

(scanBasePackages = {"com.devland.meupresente.services", "com.devland.meupresente.repositorys","com.devland.meupresente.controllers"})
@ComponentScan(basePackages = {"com.devland.meupresente.services", "com.devland.meupresente.repositorys","com.devland.meupresente.controllers"})
@EntityScan(value = {"com.devland.meupresente.models"})
@EnableJpaRepositories(basePackages = "com.devland.meupresente.repositorys")
public class MeupresenteApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MeupresenteApplication.class, args);
	}

}
