package com.ownk.practical.backend;

import com.ownk.practical.backend.model.Producto;
import com.ownk.practical.backend.model.Vendedor;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan("com.ownk.practical.backend.mapper")
@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
        
        @Override
        protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
            return application.sources(BackendApplication.class);
        
        }
        
}
