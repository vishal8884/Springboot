package com.vishal.loginLogout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.loginLogout.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
}
