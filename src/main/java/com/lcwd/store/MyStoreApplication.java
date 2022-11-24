package com.lcwd.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcwd.store.repository.UserDao;

@SpringBootApplication
public class MyStoreApplication {

	@Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(MyStoreApplication.class, args);
	}
}
