package com.lcwd.store.repository;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lcwd.store.entities.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger logger= LoggerFactory.getLogger(UserDao.class);
	
	public UserDao(JdbcTemplate template) {
		this.jdbcTemplate = template; 
		logger.info("Template created {}", jdbcTemplate);
		
		//create table: if not exist
		String queryString = "create table IF NOT EXISTS jdbc_user(id int primary key , name varchar(40),email varchar(40), password varchar(50), about varchar(500), gender varchar(40))";
		
		jdbcTemplate.update(queryString);
	}
//create user
	public User createUser(User user) {
		
		String queryString = "insert into jdbc_user(id,name,email,password,about,gender) values(?,?,?,?,?,?)";
		int update = jdbcTemplate.update(queryString,user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getAbout(),user.getGender());
		 logger.info("{} rows added",update);
		 return user;
	}
	
	//get all users
	public List<User> getAllUsers(){
		String queryString = "select * from jdbc_user";
		List<Map<String, Object>>  listOfUsers = jdbcTemplate.queryForList(queryString);
		
	List<User> listUsers =	listOfUsers.stream().map(m->{
			User user = new User();
			user.setId(Integer.parseInt(m.get("id").toString()));
			user.setName(m.get("name").toString());
			user.setEmail(m.get("email").toString());
			user.setPassword(m.get("password").toString());
			user.setAbout(m.get("about").toString());
			user.setGender(m.get("gender").toString());
			
			return user;
		}).collect(Collectors.toList());
		return listUsers;
	}
}
