package com.lcwd.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcwd.store.entities.User;

@SpringBootApplication
public class MyStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyStoreApplication.class, args);
		User user = User.builder()
		    .gender("male")
		    .name("denis")
		    .password("asdadaxa")
		    .build();
			System.out.println(user);	
		
	}

}
