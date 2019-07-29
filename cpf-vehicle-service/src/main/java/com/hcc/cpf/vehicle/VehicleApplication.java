package com.hcc.cpf.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan( basePackages = {"com.hcc.cpf.vehicle.entity"})
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

}
