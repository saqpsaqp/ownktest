package com.ownk.practical.backend;

import com.ownk.practical.backend.model.Producto;
import com.ownk.practical.backend.model.Vendedor;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Vendedor.class)
@MapperScan("com.ownk.practical.backend.mapper")
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
