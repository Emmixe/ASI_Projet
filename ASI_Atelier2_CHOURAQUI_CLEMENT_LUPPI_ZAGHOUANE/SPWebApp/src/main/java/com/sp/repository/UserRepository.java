package com.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;
import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
	public Optional<User> findById(Integer id);
	public Iterable<User> findAll();
	public Optional<User> findBySurname(String surname);
}
