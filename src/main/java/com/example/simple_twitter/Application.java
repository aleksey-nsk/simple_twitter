package com.example.simple_twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args); // launch an application
  }
}

/*
1) Debug 'Application.main()'
2) localhost:8080/greeting => Hello, World
3) localhost:8080/greeting?name=Alex => Hello, Alex
4) localhost:8080/ => this is main
 */
