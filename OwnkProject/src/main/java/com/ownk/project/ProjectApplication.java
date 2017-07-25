package com.ownk.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan("com.ownk.project.mappers")
@SpringBootApplication
public class ProjectApplication {
        public static void main(String[] args) {
                SpringApplication.run(ProjectApplication.class, args);
        }
}
