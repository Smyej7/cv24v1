package fr.univrouen.cv24v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cv24v1Application {

	public static void main(String[] args) {
		System.getProperties().put("server.port", 8100);
		SpringApplication.run(Cv24v1Application.class, args);
	}

}