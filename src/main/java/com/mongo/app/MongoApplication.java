package com.mongo.app;

//import java.util.Date;
//import java.util.TimeZone;

//import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication {
	
//	@PostConstruct
//    public void init(){
//      // Setting Spring Boot SetTimeZone
//      TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
//      System.out.println("Date in UTC: " + new Date().toString());
//    }

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

}
