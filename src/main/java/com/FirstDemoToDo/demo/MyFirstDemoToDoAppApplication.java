package com.FirstDemoToDo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.FirstDemoToDo.demo.dao")
public class MyFirstDemoToDoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstDemoToDoAppApplication.class, args);
    }

}
