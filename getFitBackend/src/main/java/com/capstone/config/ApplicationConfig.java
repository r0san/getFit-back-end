package com.capstone.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.capstone.repository")
@EntityScan (basePackages = "com.capstone.entity")
public class ApplicationConfig {

}
