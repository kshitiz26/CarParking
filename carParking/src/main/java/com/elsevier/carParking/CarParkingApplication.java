package com.elsevier.carParking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.elsevier.carParking.model", "com.elsevier.carParking.util"})
@EnableJpaRepositories("com.elsevier.carParking.repository")
public class CarParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingApplication.class, args);
	}

}
