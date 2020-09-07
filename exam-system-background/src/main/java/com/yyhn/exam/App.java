package com.yyhn.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
