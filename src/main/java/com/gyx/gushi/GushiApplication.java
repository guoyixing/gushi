package com.gyx.gushi;

import com.github.pagehelper.PageHelper;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class GushiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GushiApplication.class, args);
	}
}
