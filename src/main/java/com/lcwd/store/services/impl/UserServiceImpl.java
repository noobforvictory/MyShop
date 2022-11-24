package com.lcwd.store.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lcwd.store.dtos.UserDto;
import com.lcwd.store.entities.User;
import com.lcwd.store.repository.UserDao;
import com.lcwd.store.services.UserService;

@Service
@Primary
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		User createUser = userDao.createUser(user);
		return mapper.map(createUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userDtoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUser(int userDtoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAll() {
		
		List<User> allUsers = userDao.getAllUsers();
		List<UserDto> collectDtos = allUsers.stream().map(user->mapper.map(user, UserDto.class)).collect(Collectors.toList());
		return collectDtos;
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
