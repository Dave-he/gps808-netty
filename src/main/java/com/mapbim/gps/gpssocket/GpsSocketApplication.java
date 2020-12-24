package com.mapbim.gps.gpssocket;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class GpsSocketApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GpsSocketApplication.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
	}

}
