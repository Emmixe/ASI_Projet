package com.sp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	private List getUser(UserDto u) {
		List<User> userList = uRepository.findBySurname(u.getSurname());
		return userList;
	}
	
	public boolean logIn(UserDto u) {
		boolean ret = false;
		if (!checkUser(u)) {
			List uList= getUser(u);
			User user = (User) uList.get(0);
			System.out.println(user.getPasswd()+u.getPassword());
			if (user.getPasswd().equals(u.getPassword()))
			{
				
				System.out.println(" Connecté ");
				ret = true;
			}
		}
		else {
			System.out.println(" Nom introuvable ");
		}
		return ret;
	}
	
	private boolean checkUser(UserDto u) {
		return getUser(u).isEmpty();
	}
	
	public boolean addUser(UserDto u) {
		boolean ret = false;
		if (checkUser(u)) {
			User user = new User(u.getName(), u.getSurname(), u.getPassword());
			User createdUser=uRepository.save(user);
			ret = true;
		}
		else {
			System.out.println(" Nom deja utilisé ");
		}
		return(ret);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

}
