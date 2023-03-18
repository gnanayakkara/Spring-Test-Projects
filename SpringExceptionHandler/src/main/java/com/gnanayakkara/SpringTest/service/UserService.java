package com.gnanayakkara.SpringTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnanayakkara.SpringTest.Exception.UserNotFoundException;
import com.gnanayakkara.SpringTest.dto.UserRequest;
import com.gnanayakkara.SpringTest.entity.User;
import com.gnanayakkara.SpringTest.repository.UserRepository;

/*
 * 7 Oct 2022
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userRequest) {

		User entity = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getName());
		return repository.save(entity);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User getUser(int id) throws UserNotFoundException {
		Optional<User> user =  repository.findByUserId(id);
		return user.orElseThrow(() -> new UserNotFoundException("User not found with id : " + id));
	}
}
