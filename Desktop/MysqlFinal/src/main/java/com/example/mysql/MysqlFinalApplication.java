package com.example.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlFinalApplication {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		SpringApplication.run(MysqlFinalApplication.class, args);
	    long endTime = System.nanoTime();

	    System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
		
	}

}

