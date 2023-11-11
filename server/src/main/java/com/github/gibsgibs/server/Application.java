package com.github.gibsgibs.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.github.gibsgibs.server.settings.BlizzardSettings;

@SpringBootApplication
@EnableConfigurationProperties(BlizzardSettings.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
