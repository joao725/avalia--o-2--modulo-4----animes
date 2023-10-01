package br.com.tech4me.catalogoanimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogoAnimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoAnimesApplication.class, args);
	}

}
