package com.mapbim.gps.gpssocket;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import io.github.hylexus.jt808.boot.annotation.EnableJt808ServerAutoConfig;

@SpringBootApplication
//@EnableJt808ServerAutoConfig
public class GpsSocketApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GpsSocketApplication.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
	}

}
