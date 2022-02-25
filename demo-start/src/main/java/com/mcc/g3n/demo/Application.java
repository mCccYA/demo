package com.mcc.g3n.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.mcc.g3n.demo"})
public class Application {

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

}
