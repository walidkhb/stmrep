package com.stm.service;

import com.stm.form.SignupForm;
import com.stm.form.UserEditForm;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.User;
import com.stm.data.entity.User;

public interface UserService {
	
	
	public abstract User findOne(long userId);

	public abstract void update(long userId, UserEditForm userEditForm);
	User findById(Long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();
	 Iterable<User> listAllUsers();

	    User getUserById(Long id);

	   

	    void deleteUser(Long id);

	    Page<User> findAll(Pageable pageable);
	boolean isUserExist(User user);
}
