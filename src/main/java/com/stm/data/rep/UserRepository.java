package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stm.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUsername(String username);
	User findByName(String name);

}
