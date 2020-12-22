package com.mapbim.gps.gpssocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.hylexus.jt808.boot.annotation.EnableJt808ServerAutoConfig;

@SpringBootApplication
@EnableJt808ServerAutoConfig
public class GpsSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpsSocketApplication.class, args);
	}

}
