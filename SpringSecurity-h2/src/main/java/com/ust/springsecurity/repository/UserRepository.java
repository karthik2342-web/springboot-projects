package com.ust.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.springsecurity.service.MyUser;

public interface UserRepository  extends JpaRepository<MyUser,Long>{
	Optional<MyUser> findByUsername(String username);
}
