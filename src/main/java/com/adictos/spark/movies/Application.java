package com.adictos.spark.movies;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.adictos.spark.movies.config.DatabaseConfig;
import com.adictos.spark.movies.service.MoviesService;

@Configuration
@ComponentScan({"com.adictos.spark.movies"})
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class, DatabaseConfig.class);
    	new MoviesApplication(ctx.getBean(MoviesService.class));
        ctx.registerShutdownHook();
	}
	
}
