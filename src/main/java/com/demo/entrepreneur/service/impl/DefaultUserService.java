package com.demo.entrepreneur.service.impl;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entrepreneur.dao.UserRepository;
import com.demo.entrepreneur.dto.UserDto;
import com.demo.entrepreneur.model.User;
import com.demo.entrepreneur.model.mapping.mapper.impl.UserMapper;
import com.demo.entrepreneur.model.mapping.populator.impl.UpdateUserPopulator;
import com.demo.entrepreneur.service.UserService;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UpdateUserPopulator updateUserPopulator;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerNewUser(UserDto userDto) {
		User user = userMapper.dataToEntity(userDto);
		userRepository.save(user);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByLogin(String login) {
		return userRepository.findByLogin(login).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	@Override
	public User updateUserByLogin(UserDto userDto) {
		final User user = getUserByLogin(userDto.getLogin());
		return updateUserPopulator.populateDataToEntity(userDto, user);
	}

	@Override
	public void deleteUserByLogin(String login) {
		final User user = getUserByLogin(login);
		userRepository.delete(user);
	}

}
