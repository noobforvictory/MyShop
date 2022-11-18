package com.lcwd.store.services.impl;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lcwd.store.dtos.UserDto;
import com.lcwd.store.entities.User;
import com.lcwd.store.services.UserService;

@Service
@Primary
public class FakeUserServiceImpl implements UserService {

	private List<User> users = new ArrayList<>();
	
	@Autowired
	private ModelMapper mapper;

	private Logger logger = LoggerFactory.getLogger(FakeUserServiceImpl.class); 
	
	@Override
	public UserDto addUser(UserDto userDto) {
		//Dto -> entity 
		User user = mapper.map(userDto, User.class);
	    boolean	result = users.add(user);
	    logger.info("user is added: {}",result);
		return mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userDtoId) {
		List<User> updatedList = users.stream()
			 .map(user -> {
				 if(user.getId() == userDtoId) {
					 user.setId(userDto.getId());
					 user.setName(userDto.getName());
					 user.setDob(userDto.getDob());
					 user.setPassword(userDto.getPassword());
					 user.setGender(userDto.getGender());
					 user.setEmail(userDto.getEmail());
					 user.setAbout(userDto.getAbout());
					 return user;
				 }else {
					 return user;
				 }
			  }).collect(Collectors.toList());
		users = updatedList;
		
			 
		return userDto;
	}

	@Override
	public UserDto getUser(int userDtoId) {
		
		User user1 = users.stream()
				          .filter(user-> user.getId()==userDtoId)
				          .findFirst()
				          .orElseThrow(()-> new RuntimeException("user with given id not found"));
		return mapper.map(user1, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> userDtos = users.stream()
				                      .map(user -> mapper.map(user,UserDto.class))
				                      .collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(int userDtoId) {
		List<User> newList = users.stream()
		     .filter( user -> user.getId() != userDtoId )
		     .collect( Collectors.toList() );
		users = newList;
		
	}

	@Override
	public List<UserDto> searchUsers(String keywords) {
		List<User> list = users.stream()
		     .filter(user -> user.getName().contains(keywords) )
		     .collect(Collectors.toList());
		List<UserDto> userDtos = list.stream()
									 .map(user -> mapper.map(user,UserDto.class))
									 .collect(Collectors.toList());
		return userDtos;
	}

}
