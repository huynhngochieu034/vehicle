package com.hcc.cpf.media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 * Main class: initialize and start the application.
 * 
 * @author phuchn.fa
 *
 */
@RestController
@SpringBootApplication
@EntityScan("com.hcc.cpf.media.entity")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MediaServiceApplication extends SpringBootServletInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(MediaServiceApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(MediaServiceApplication.class);
	}

	/**
	 * Start application.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		LOG.info("==== Start media-service application ====");
		SpringApplication.run(MediaServiceApplication.class, args); // NOSONAR
		LOG.info("==== Start media-service application success ====");
	}
}