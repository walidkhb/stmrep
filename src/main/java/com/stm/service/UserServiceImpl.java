package com.stm.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.rep.UserRepository;
import com.stm.form.SignupForm;
import com.stm.form.UserEditForm;
import com.stm.util.MyUtil;
import com.stm.data.entity.Group;
import com.stm.data.entity.User;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements UserService, UserDetailsService {
	
    private final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	
	private GroupService groupService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,
			PasswordEncoder passwordEncoder,GroupService groupService) {
		
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.groupService=groupService;

	      
		
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		return new UserDetailsImpl(user);
	}

	@Override
	public User findOne(long userId) {
		
		User user = userRepository.findOne(userId);
		return user;

	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(long userId, UserEditForm userEditForm) {
		
		User user = userRepository.findOne(userId);
		user.setName(userEditForm.getName());
		userRepository.save(user);
		
	}
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}

	@Override
	public Iterable<User> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);		
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	

}
