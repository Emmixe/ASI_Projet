package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.model.User;
import com.sp.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		List<Integer> cardidList=new ArrayList<Integer>();
		
		//get Rand Cards

		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method and default Headers.
		Integer r_id = restTemplate.getForObject("http://localhost:8081/randcard", Integer.class);
		cardidList.add(r_id);
		
		// Update user
		user.setListCards(cardidList);
		
		
		User createdUser = userRepository.save(user);
		System.out.println(createdUser);
		return createdUser;
	}

	public User getUserById(int id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		} else {
			return null;
		}
	}
	
	public List<User> getUserByName(String name) {
		List<User> userList = userRepository.findByName(name);
		return userList;
	}
	
	public User getUserBySurname(String surname) // return unique user, force unique surname
	{
		Optional<User> userOpt = userRepository.findBySurname(surname);
		if (userOpt.isPresent()) {
			return userOpt.get();
		} else {
			return null;
		}
	}
	
	public Iterable<User> getAllUsers() {
		Iterable<User> users = userRepository.findAll();
		return users;
	}

	public static Integer getRandomCard() {
		
		return null;
	}

}