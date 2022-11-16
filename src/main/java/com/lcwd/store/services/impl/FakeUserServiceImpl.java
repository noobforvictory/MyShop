package com.lcwd.store.services.impl;

import java.util.ArrayList;
import java.util.List;

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
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userDtoId) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userDtoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDto> searchUsers(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}
