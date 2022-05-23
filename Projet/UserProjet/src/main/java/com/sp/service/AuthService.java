package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.UserDto;
import com.sp.exception.FunctionnnalException;
import com.sp.model.User;

public class AuthService {
	
	@Autowired
	UserService uService;
		
	private User getUserBySurname(String surname)
	{
		return uService.getUserBySurname(surname);
	}
	
	public int login(UserDto u) throws FunctionnnalException {
		if (checkUser(u)) {
			throw new FunctionnnalException(" Nom introuvable ");
		}
		User user = getUserBySurname(u.getSurname());
		if (!user.getPasswd().equals(u.getPasswd())){
			throw new FunctionnnalException(" Mauvais mdp ");
		}
		return user.getId();
		}
		
	
	private boolean checkUser(UserDto u) {
		return getUserBySurname(u.getSurname()) == null;
	}
	
	public Integer addUser(UserDto u) throws FunctionnnalException {
		if (!checkUser(u)) {
			throw new FunctionnnalException(" Surnom deja utilisé ");
		}
		
		User user = new User(u.getName(), u.getSurname(), u.getPasswd());
		User createdUser=uService.addUser(user);
		return createdUser.getId();
	}
	
	public void logout(int id)
	{
		uService.getUserById(id);
	}
	

}
