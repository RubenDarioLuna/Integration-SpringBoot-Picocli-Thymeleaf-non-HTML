package com.lunaru.democli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * *
 *
 * @author SpringBoot
 * @version 1.0
 * @since 3/1/2021
 */
@SpringBootApplication
public class DemoCliApplication
{
    public static void main(String[] args) {
        //SpringApplication.run(DemoCliApplication.class, args);
        System.exit( SpringApplication.exit( SpringApplication.run( DemoCliApplication.class, args ) ) );
    }
}
